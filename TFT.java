import java.util.ArrayList;

public class TFT {
    Unit [] units;
    int [] activate;
    public TFT(Unit [] units, int [] activate){
        this.activate = activate;
        this.units = units;
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
            // Initialize trait count keeper with zeros
            int [] ar = new int[activate.length];

            // Count total traits for the n-1 units
            for (int j=0;j<n-1;j++) {
                for(int i : units[pointers[j]].traits){
                    ar[i]++;
                }
            }
//            boolean flag = false;
//            int position = 0;
//            for (int j=0;j<n-1;j++) {
//                for(int i : units[pointers[j]].traits){
//                    if(ar[i] < activate[i]){
//                        flag=true;
//                    }
//                    ar[i]++;
//                }
//                if(!flag){
//                    position=j;
//                    break;
//                }
//            }
//            if(!flag && n!=1){
//                counter =n-position+1;
//                for(int i=n-1-counter;i>=0;i--){
//                    if(pointers[i]==units.length-counter-1){
//                        counter++;
//                    }
//                    else
//                        break;
//                }
//                if(counter==n)
//                    break;
//                pointers[n-counter-1]= Math.min(pointers[n-counter-1]+1, units.length-1-counter);
//
//                for(int i=n-counter;i<n;i++){
//                    pointers[i]=pointers[i-1]+1;
//                }
//                continue;
//            }
            // Count the #no active traits from n-1 units
            int activeTraits = 0;
            int potentialTraits = 0;
            for(int i=0;i<ar.length;i++){
                if (ar[i] >= activate[i])
                    activeTraits++;
                if(ar[i] == activate[i]-1)
                    potentialTraits++;
            }


            if(maxActiveTraits <= activeTraits + Math.min(3,potentialTraits)) { // 3 is the maximum number of traits any unit can have

                // Recalculate #no active traits moving pointer of the nth unit
                for (int i = pointers[n - 1]; i < units.length; i++) {
                    int result = activeTraits;
                    for (int j : units[i].traits) {
                        if (ar[j] == activate[j] - 1)
                            result++;
                    }
                    if (result == maxActiveTraits) {
                        int[] solution = pointers.clone();
                        solution[n - 1] = i;
                        solutions.add(solution);
                    }
                    if (result > maxActiveTraits) {
                        maxActiveTraits = result;
                        solutions.clear();
                        int[] solution = pointers.clone();
                        solution[n - 1] = i;
                        solutions.add(solution);
                    }
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
        Unit Kench = new Unit(Thomas,"Tahm Kench");

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
        TFT tft = new TFT(units,traits);
        ArrayList<int []> solutions= tft.maxStandUnited(7);

        if(solutions.isEmpty())
            System.out.println("No non-unique trait can be activated using that many units!");
        else {
            System.out.println(solutions.size());
            for (int [] solution : solutions) {
                for(int i: solution){
                    System.out.print(units[i] + " ");
                }
                System.out.println();
            }
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
