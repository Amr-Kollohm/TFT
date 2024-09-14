import java.util.ArrayList;
import java.util.HashSet;

public class TFT {
    Unit [] units;
    int [] activate;
    HashSet<Integer> [] hs;
    public TFT(Unit [] units, int [] activate, HashSet<Integer> [] hs){
        this.activate = activate;
        this.units = units;
        this.hs=hs;
    }

    public ArrayList<int []> maxStandUnited(int n){
        ArrayList<int[]> solutions= new ArrayList<>();
        int [] pointers = new int[n];
        int maxActiveTraits=0;

        for(int i=0;i<n;i++){
            pointers[i]=i;
        }

        int counter=0;
        while(true) {
            // Count total traits for the n-1 units
            int [] ar = new int[activate.length];
            for (int j=0;j<n-1;j++) {
                for(int i : units[pointers[j]].traits){
                    ar[i]++;
                }
            }
            // Count the #no active traits from n-1 units
            int activeTraits = 0;
            for(int i=0;i<ar.length;i++){
                if (ar[i] >= activate[i])
                    activeTraits++;
            }

            // Recalculate #no active traits moving pointer of the nth unit
            for(int i=pointers[n-1];i<units.length;i++) {
                int result =activeTraits;
                for(int j :units[i].traits){
                    if(ar[j] == activate[j]-1)
                        result++;
                }
                if (result == maxActiveTraits) {
                    int [] solution =pointers.clone();
                    solution[n-1]=i;
                    solutions.add(solution);
                }
                if (result > maxActiveTraits) {
                    maxActiveTraits = result;
                    solutions.clear();
                    int [] solution =pointers.clone();
                    solution[n-1]=i;
                    solutions.add(solution);
                }
            }

            // Mechanism for controlling pointers
            counter=1;
            for(int i=n-2;i>=0;i--){
                if(pointers[i]==units.length-counter-1){
                    counter++;
                }
                else
                    break;
            }
            if(counter==n)
                break;
            pointers[n-counter-1]= Math.min(pointers[n-counter-1]+1, units.length-1-counter);

            for(int i=n-counter;i<n;i++){
                pointers[i]=pointers[i-1]+1;
            }
        }

        // Calculate #no active traits for the very last combination of units
        int [] ar = new int[activate.length];
        for (int j=0;j<n;j++) {
            for(int i : units[pointers[j]].traits){
                ar[i]++;
            }
        }

        int activeTraits = 0;
        for(int i=0;i<ar.length;i++){
            if (ar[i] >= activate[i])
                activeTraits++;
        }


        if (activeTraits > maxActiveTraits) {
            solutions.clear();
            solutions.add(pointers.clone());
        }
        if (activeTraits == maxActiveTraits) {
            solutions.add(pointers.clone());
        }

        // Return the results
        if(maxActiveTraits==0)
            return new ArrayList<int[]>();
        return solutions;
    }

    public static void main(String [] args){
        int [] ahri = {18,0};
        Unit Ahri = new Unit(ahri,"Ahri");

        int [] akali = {8,21,16};
        Unit Akali = new Unit(akali,"Akali");

        int [] ashe  = {3,16};
        Unit Ashe = new Unit(ashe,"Ashe");

        int [] bard = {18,9,17};
        Unit Bard = new Unit(bard,"Bard");

        int [] blitzcrank = {6,20};
        Unit Blitzcrank = new Unit(blitzcrank,"Blitz");

        int [] briar = {3,19};
        Unit Briar = new Unit(briar,"Briar");

        int [] camille = {1,16};
        Unit Camille = new Unit(camille,"Camille");

        int [] cassiopeia = {10,14};
        Unit Cassiopeia = new Unit(cassiopeia,"Cassiopeia");

        int [] diana = {5,11};
        Unit Diana = new Unit(diana,"Diana");

        int [] elise = {3,19};
        Unit Elise = new Unit(elise,"Elise");

        int [] ezreal = {12,7};
        Unit Ezreal = new Unit(ezreal,"Ezreal");

        int [] fiora = {21,10};
        Unit Fiora = new Unit(fiora,"Fiora");

        int [] galio = {15,20,7};
        Unit Galio = new Unit(galio,"Galio");

        int [] gwen = {21,9};
        Unit Gwen = new Unit(gwen,"Gwen");

        int [] hecarim = {11, 0, 16};
        Unit Hecarim = new Unit(hecarim,"Hecarim");

        int [] hwei = {12,5};
        Unit Hwei = new Unit(hwei,"Hwei");

        int [] jax = {1,16};
        Unit Jax = new Unit(jax,"Jax");

        int [] jayce = {7,19};
        Unit Jayce = new Unit(jayce,"Jayce");

        int [] jinx = {9,13};
        Unit Jinx = new Unit(jinx,"Jinx");

        int [] kalista = {16,4};
        Unit Kalista = new Unit(kalista,"Kalista");

        int [] karma = {1,14};
        Unit Karma = new Unit(karma,"Karma");

        int [] kassadin = {7,16};
        Unit Kassadin = new Unit(kassadin,"Kassadin");

        int [] katarina = {4,21};
        Unit Katarina = new Unit(katarina,"Katarina");

        int [] kogmaw = {13,6};
        Unit KogMaw = new Unit(kogmaw,"KogMaw");

        int [] lilia = {4,11};
        Unit Lilia = new Unit(lilia,"Lilia");

        int [] milio = {4,18};
        Unit Milio = new Unit(milio,"Milio");

        int [] mordekaiser = {20,3};
        Unit Mordekaiser = new Unit(mordekaiser,"Mordekaiser");

        int [] morgana = {10,17};
        Unit Morgana = new Unit(morgana,"Morgana");

        int [] nami = {3,15};
        Unit Nami = new Unit(nami,"Nami");

        int [] nasus = {8,19};
        Unit Nasus = new Unit(nasus,"Nasus");

        int [] neeko = {10,19};
        Unit Neeko = new Unit(neeko,"Neeko");

        int [] nilah = {3,21};
        Unit Nilah = new Unit(nilah,"Nilah");

        int [] nomsy = {13,2};
        Unit Nomsy = new Unit(nomsy,"Nomsy");

        int [] norra = {15,7};
        Unit Norra = new Unit(norra,"Nora & Yuumi");

        int [] nunu = {6,11};
        Unit Nunu = new Unit(nunu,"Nunu");

        int [] olaf = {13,5};
        Unit Olaf = new Unit(olaf,"Olaf");

        int [] poppy = {11,10};
        Unit Poppy = new Unit(poppy,"Poppy");

        int [] rakan = {4,17};
        Unit Rakan = new Unit(rakan,"Rakan");

        int [] rumble = {12,20};
        Unit Rumble = new Unit(rumble,"Rumble");

        int [] ryze = {18,7};
        Unit Ryze = new Unit(ryze,"Ryze");

        int [] seraphine = {15,4};
        Unit Seraphine = new Unit(seraphine,"Seraphine");

        int [] shen = {8,11};
        Unit Shen = new Unit(shen,"Shen");

        int [] shyvana = {2,19};
        Unit Shyvana = new Unit(shyvana,"Shyvana");

        int [] smolder = {2,12};
        Unit Smolder = new Unit(smolder,"Smolder");

        int [] soraka = {15,9};
        Unit Soraka = new Unit(soraka,"Soraka");

        int [] swain = {5,19};
        Unit Swain = new Unit(swain,"Swain");

        int [] syndra = {3,14};
        Unit Syndra = new Unit(syndra,"Syndra");

        int [] Thomas = {0,20};
        Unit Kench = new Unit(Thomas,"Tahm_Kench");

        int [] taric = {11,7};
        Unit Taric = new Unit(taric,"Taric");

        int [] tristana = {4,12};
        Unit Tristana = new Unit(tristana,"Tristana");

        int [] twitch = {5,13};
        Unit Twitch = new Unit(twitch,"Twitch");

        int [] varus = {8,12};
        Unit Varus = new Unit(varus,"Varus");

        int [] veigar = {15,6};
        Unit Veigar = new Unit(veigar,"Veigar");

        int [] vex = {15,1};
        Unit Vex = new Unit(vex,"Vex");

        int [] warwick = {20,5};
        Unit Warwick = new Unit(warwick,"Warwick");

        int [] xerath = {0};
        Unit Xerath = new Unit(xerath,"Xerath");

        int [] ziggs = {14, 6};
        Unit Ziggs = new Unit(ziggs,"Ziggs");

        int [] zilean = {17,1,5};
        Unit Zilean = new Unit(zilean,"Zilean");

        int [] zoe = {10,18,7};
        Unit Zoe = new Unit(zoe,"Zoe");

        Unit [] units = {Ahri,Akali,Ashe,Bard,Blitzcrank,Briar,Camille,Cassiopeia,Diana,Elise,Ezreal,Fiora,Galio,Gwen,Hecarim,Hwei,Jax,Jayce,Jinx,Kalista,Karma,Kassadin,Katarina,KogMaw,Lilia,Milio,Mordekaiser,Morgana,Nami,Nasus,Neeko,Nilah,Nomsy,Norra,Nunu,Olaf,Poppy,Rakan,Rumble,Ryze,Seraphine,Shen,Shyvana,Smolder,Soraka,Swain,Syndra,Kench,Taric,Tristana,Twitch,Varus,Veigar,Vex,Warwick,Xerath,Ziggs,Zilean,Zoe};

        // Arcana Chrono Dragon Eldritch Faerie Frost Honeymancy Portal Pyro Sugarcraft Witchcraft Bastion Blaster Hunter Incantor Mage Multistriker Preserver Scholar Shapeshifter Vanguard Warrior
        int [] traits = {2,2,2,3,2,3,3,3,2,2,2,2,2,2,2,3,3,2,2,2,2,2};

        HashSet<Integer> []traitUnits= new HashSet[22];

        HashSet<Integer> Arcana= new HashSet<Integer>();
        Arcana.add(0);
        Arcana.add(4);
        Arcana.add(47);
        Arcana.add(56);
        traitUnits[0]=Arcana;

        HashSet<Integer> Chrono= new HashSet<Integer>();
        Chrono.add(6);
        Chrono.add(16);
        Chrono.add(20);
        Chrono.add(53);
        Chrono.add(58);
        traitUnits[1]=Chrono;

        HashSet<Integer> Dragon= new HashSet<Integer>();
        Dragon.add(32);
        Dragon.add(42);
        Dragon.add(43);
        traitUnits[2]=Dragon;

        HashSet<Integer> Eldritch= new HashSet<Integer>();
        Eldritch.add(2);
        Eldritch.add(5);
        Eldritch.add(9);
        Eldritch.add(26);
        Eldritch.add(28);
        Eldritch.add(31);
        Eldritch.add(46);
        traitUnits[3]=Eldritch;

        HashSet<Integer> Faerie= new HashSet<Integer>();
        Faerie.add(19);
        Faerie.add(22);
        Faerie.add(24);
        Faerie.add(25);
        Faerie.add(37);
        Faerie.add(40);
        Faerie.add(49);
        traitUnits[4]=Faerie;

        HashSet<Integer> Frost= new HashSet<Integer>();
        Frost.add(8);
        Frost.add(15);
        Frost.add(35);
        Frost.add(45);
        Frost.add(50);
        Frost.add(54);
        Frost.add(58);
        traitUnits[5]=Frost;

        HashSet<Integer> Honeymancy= new HashSet<Integer>();
        Honeymancy.add(4);
        Honeymancy.add(23);
        Honeymancy.add(34);
        Honeymancy.add(52);
        Honeymancy.add(57);
        traitUnits[6]=Honeymancy;

        HashSet<Integer> Portal= new HashSet<Integer>();
        Portal.add(10);
        Portal.add(12);
        Portal.add(17);
        Portal.add(21);
        Portal.add(33);
        Portal.add(39);
        Portal.add(48);
        Portal.add(59);
        traitUnits[7]=Portal;

        HashSet<Integer> Pyro= new HashSet<Integer>();
        Pyro.add(1);
        Pyro.add(29);
        Pyro.add(41);
        Pyro.add(42);
        traitUnits[8]=Pyro;

        HashSet<Integer> Sugarcraft= new HashSet<Integer>();
        Sugarcraft.add(3);
        Sugarcraft.add(13);
        Sugarcraft.add(18);
        Sugarcraft.add(38);
        Sugarcraft.add(44);
        traitUnits[9]=Sugarcraft;

        HashSet<Integer> Witchcraft= new HashSet<Integer>();
        Witchcraft.add(7);
        Witchcraft.add(11);
        Witchcraft.add(27);
        Witchcraft.add(30);
        Witchcraft.add(36);
        Witchcraft.add(59);
        traitUnits[10]=Witchcraft;

        HashSet<Integer> Bastion= new HashSet<Integer>();
        Bastion.add(8);
        Bastion.add(14);
        Bastion.add(24);
        Bastion.add(34);
        Bastion.add(36);
        Bastion.add(41);
        Bastion.add(48);
        traitUnits[11]=Bastion;

        HashSet<Integer> Blaster= new HashSet<Integer>();
        Blaster.add(10);
        Blaster.add(15);
        Blaster.add(38);
        Blaster.add(43);
        Blaster.add(49);
        Blaster.add(51);
        traitUnits[12]=Blaster;

        HashSet<Integer> Hunter= new HashSet<Integer>();
        Hunter.add(18);
        Hunter.add(23);
        Hunter.add(32);
        Hunter.add(35);
        Hunter.add(50);
        traitUnits[13]=Hunter;

        HashSet<Integer> Incantor= new HashSet<Integer>();
        Incantor.add(7);
        Incantor.add(20);
        Incantor.add(57);
        Incantor.add(46);
        traitUnits[14]=Incantor;

        HashSet<Integer> Mage= new HashSet<Integer>();
        Mage.add(12);
        Mage.add(28);
        Mage.add(33);
        Mage.add(40);
        Mage.add(44);
        Mage.add(52);
        Mage.add(53);
        traitUnits[15]=Mage;

        HashSet<Integer> Multistriker= new HashSet<Integer>();
        Multistriker.add(1);
        Multistriker.add(2);
        Multistriker.add(6);
        Multistriker.add(14);
        Multistriker.add(16);
        Multistriker.add(19);
        Multistriker.add(21);
        traitUnits[16]=Multistriker;

        HashSet<Integer> Preserver= new HashSet<Integer>();
        Preserver.add(3);
        Preserver.add(27);
        Preserver.add(37);
        Preserver.add(58);
        traitUnits[17]=Preserver;

        HashSet<Integer> Scholar= new HashSet<Integer>();
        Scholar.add(0);
        Scholar.add(3);
        Scholar.add(25);
        Scholar.add(39);
        Scholar.add(59);
        traitUnits[18]=Scholar;

        HashSet<Integer> Shapeshifter= new HashSet<Integer>();
        Shapeshifter.add(5);
        Shapeshifter.add(9);
        Shapeshifter.add(17);
        Shapeshifter.add(29);
        Shapeshifter.add(30);
        Shapeshifter.add(42);
        Shapeshifter.add(45);
        traitUnits[19]=Shapeshifter;

        HashSet<Integer> Vanguard= new HashSet<Integer>();
        Vanguard.add(4);
        Vanguard.add(12);
        Vanguard.add(26);
        Vanguard.add(38);
        Vanguard.add(47);
        Vanguard.add(54);
        traitUnits[20]=Vanguard;

        HashSet<Integer> Warrior= new HashSet<Integer>();
        Warrior.add(1);
        Warrior.add(11);
        Warrior.add(13);
        Warrior.add(22);
        Warrior.add(31);
        traitUnits[21]=Warrior;

        TFT tft = new TFT(units,traits,traitUnits);
        ArrayList<int []> solutions= tft.maxStandUnited(8);

        if(solutions.isEmpty())
            System.out.println("No non-unique trait can be activated using that many units!");
        else
            for (int [] solution : solutions) {
                for (int i : solution)
                    System.out.print(units[i] + " ");
                System.out.println();
            }
    }
}
class Unit{
    int [] traits;
    String name;

    public Unit(int [] traits, String name){
        this.traits= traits;
        this.name= name;
    }

    public String toString(){
        return this.name;
    }
}
