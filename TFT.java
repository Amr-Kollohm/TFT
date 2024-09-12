import java.util.HashMap;
import java.util.Map;

public class TFT {
    Unit [] units;
    Map<String,Integer> activate;
    public TFT(Unit [] units, HashMap<String, Integer> activate){
        this.activate = activate;
        this.units = units;
    }

    public int [] maxStandUnited(int n){
        int [] pointers = new int[n];
        int [] solution = new int[n];
        int maxActiveTraits=-1;

        for(int i=0;i<n;i++){
            pointers[i]=i;
        }

        int counter=0;
        while(true) {
            counter=1;
            // Initialize trait count keeper with zeros
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            for(String str: activate.keySet()){
                hm.put(str,0);
            }
            // Count total traits for the n-1 units
            for (int j=0;j<n-1;j++) {
                for(String str : units[pointers[j]].traits){
                    hm.put(str,hm.get(str)+1);
                }
            }
            // Count the #no active traits from n-1 units
            int activeTraits = 0;
            for (String trait : hm.keySet()) {
                if (hm.get(trait) >= activate.get(trait))
                    activeTraits++;
            }

            // Recalculate #no active traits moving pointer of the nth unit
            for (int i=pointers[n-1];i<units.length;i++) {
                int result =activeTraits;
                for(String str :units[i].traits){
                    if(hm.get(str)==activate.get(str)-1)
                        result++;
                }
                if (result > maxActiveTraits) {
                    maxActiveTraits = result;
                    solution = pointers.clone();
                    solution[n-1]=i;
                }
            }

            // Mechanism for controlling pointers
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
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for(String str: activate.keySet()){
            hm.put(str,0);
        }
        for(int j=units.length-1-n;j<n;j++){
            for(String str : units[pointers[j]].traits){
                hm.put(str,hm.get(str)+1);
            }
        }

        int activeTraits = 0;
        for (String trait : hm.keySet()) {
            if (hm.get(trait) >= activate.get(trait))
                activeTraits++;
        }
        
        if (activeTraits > maxActiveTraits) {
            solution = pointers.clone();
        }

        
        // Return the results
        if(maxActiveTraits<=0)
            return new int [0];
        return solution;
    }

    public static void main(String [] args){
        String [] ahri = {"Scholar","Arcana"};
        Unit Ahri = new Unit(ahri,"Ahri");

        String [] akali = {"Pyro","Warrior","Multistriker"};
        Unit Akali = new Unit(akali,"Akali");

        String [] ashe  = {"Eldritch","Multistriker"};
        Unit Ashe = new Unit(ashe,"Ashe");

        String [] bard = {"Scholar","Sugarcraft","Preserver"};
        Unit Bard = new Unit(bard,"Bard");

        String [] blitzcrank = {"Honeymancy","Vanguard"};
        Unit Blitzcrank = new Unit(blitzcrank,"Blitz");

        String [] briar = {"Eldritch","Shapeshifter"};
        Unit Briar = new Unit(briar,"Briar");

        String [] camille = {"Chrono","Multistriker"};
        Unit Camille = new Unit(camille,"Camille");

        String [] cassiopeia = {"Witchcraft","Incantor"};
        Unit Cassiopeia = new Unit(cassiopeia,"Cassiopeia");

        String [] diana = {"Frost","Bastion"};
        Unit Diana = new Unit(diana,"Diana");

        String [] elise = {"Eldritch","Shapeshifter"};
        Unit Elise = new Unit(elise,"Elise");

        String [] ezreal = {"Blaster","Portal"};
        Unit Ezreal = new Unit(ezreal,"Ezreal");

        String [] fiora = {"Warrior","Witchcraft"};
        Unit Fiora = new Unit(fiora,"Fiora");

        String [] galio = {"Mage","Vanguard","Portal"};
        Unit Galio = new Unit(galio,"Galio");

        String [] gwen = {"Warrior","Sugarcraft"};
        Unit Gwen = new Unit(gwen,"Gwen");

        String [] hecarim = {"Bastion", "Arcana", "Multistriker"};
        Unit Hecarim = new Unit(hecarim,"Hecarim");

        String [] hwei = {"Blaster","Frost"};
        Unit Hwei = new Unit(hwei,"Hwei");

        String [] jax = {"Chrono","Multistriker"};
        Unit Jax = new Unit(jax,"Jax");

        String [] jayce = {"Portal","Shapeshifter"};
        Unit Jayce = new Unit(jayce,"Jayce");

        String [] jinx = {"Sugarcraft","Hunter"};
        Unit Jinx = new Unit(jinx,"Jinx");

        String [] kalista = {"Multistriker","Faerie"};
        Unit Kalista = new Unit(kalista,"Kalista");

        String [] karma = {"Chrono","Incantor"};
        Unit Karma = new Unit(karma,"Karma");

        String [] kassadin = {"Portal","Multistriker"};
        Unit Kassadin = new Unit(kassadin,"Kassadin");

        String [] katarina = {"Faerie","Warrior"};
        Unit Katarina = new Unit(katarina,"Katarina");

        String [] kogmaw = {"Hunter","Honeymancy"};
        Unit KogMaw = new Unit(kogmaw,"KogMaw");

        String [] lilia = {"Faerie","Bastion"};
        Unit Lilia = new Unit(lilia,"Lilia");

        String [] milio = {"Faerie","Scholar"};
        Unit Milio = new Unit(milio,"Milio");

        String [] mordekaiser = {"Vanguard","Eldritch"};
        Unit Mordekaiser = new Unit(mordekaiser,"Mordekaiser");

        String [] morgana = {"Witchcraft","Preserver"};
        Unit Morgana = new Unit(morgana,"Morgana");

        String [] nami = {"Eldritch","Mage"};
        Unit Nami = new Unit(nami,"Nami");

        String [] nasus = {"Pyro","Shapeshifter"};
        Unit Nasus = new Unit(nasus,"Nasus");

        String [] neeko = {"Witchcraft","Shapeshifter"};
        Unit Neeko = new Unit(neeko,"Neeko");

        String [] nilah = {"Eldritch","Warrior"};
        Unit Nilah = new Unit(nilah,"Nilah");

        String [] nomsy = {"Hunter","Dragon"};
        Unit Nomsy = new Unit(nomsy,"Nomsy");

        String [] norra = {"Mage","Portal"};
        Unit Norra = new Unit(norra,"Nora & Yuumi");

        String [] nunu = {"Honeymancy","Bastion"};
        Unit Nunu = new Unit(nunu,"Nunu");

        String [] olaf = {"Hunter","Frost"};
        Unit Olaf = new Unit(olaf,"Olaf");

        String [] poppy = {"Bastion","Witchcraft"};
        Unit Poppy = new Unit(poppy,"Poppy");

        String [] rakan = {"Faerie","Preserver"};
        Unit Rakan = new Unit(rakan,"Rakan");

        String [] rumble = {"Blaster","Vanguard"};
        Unit Rumble = new Unit(rumble,"Rumble");

        String [] ryze = {"Scholar","Portal"};
        Unit Ryze = new Unit(ryze,"Ryze");

        String [] seraphine = {"Mage","Faerie"};
        Unit Seraphine = new Unit(seraphine,"Seraphine");

        String [] shen = {"Pyro","Bastion"};
        Unit Shen = new Unit(shen,"Shen");

        String [] shyvana = {"Dragon","Shapeshifter"};
        Unit Shyvana = new Unit(shyvana,"Shyvana");

        String [] smolder = {"Dragon","Blaster"};
        Unit Smolder = new Unit(smolder,"Smolder");

        String [] soraka = {"Mage","Sugarcraft"};
        Unit Soraka = new Unit(soraka,"Soraka");

        String [] swain = {"Frost","Shapeshifter"};
        Unit Swain = new Unit(swain,"Swain");

        String [] syndra = {"Eldritch","Incantor"};
        Unit Syndra = new Unit(syndra,"Syndra");

        String [] Thomas = {"Arcana","Vanguard"};
        Unit Kench = new Unit(Thomas,"Tahm Kench");

        String [] taric = {"Bastion","Portal"};
        Unit Taric = new Unit(taric,"Taric");

        String [] tristana = {"Faerie","Blaster"};
        Unit Tristana = new Unit(tristana,"Tristana");

        String [] twitch = {"Frost","Hunter"};
        Unit Twitch = new Unit(twitch,"Twitch");

        String [] varus = {"Pyro","Blaster"};
        Unit Varus = new Unit(varus,"Varus");

        String [] veigar = {"Mage","Honeymancy"};
        Unit Veigar = new Unit(veigar,"Veigar");

        String [] vex = {"Mage","Chrono"};
        Unit Vex = new Unit(vex,"Vex");

        String [] warwick = {"Vanguard","Frost"};
        Unit Warwick = new Unit(warwick,"Warwick");

        String [] xerath = {"Arcana"};
        Unit Xerath = new Unit(xerath,"Xerath");

        String [] ziggs = {"Incantor", "Honeymancy"};
        Unit Ziggs = new Unit(ziggs,"Ziggs");

        String [] zilean = {"Preserver","Chrono","Frost"};
        Unit Zilean = new Unit(zilean,"Zilean");

        String [] zoe = {"Witchcraft","Scholar","Portal"};
        Unit Zoe = new Unit(zoe,"Zoe");

        Unit [] units = {Ahri,Akali,Ashe,Bard,Blitzcrank,Briar,Camille,Cassiopeia,Diana,Elise,Ezreal,Fiora,Galio,Gwen,Hecarim,Hwei,Jax,Jayce,Jinx,Kalista,Karma,Kassadin,Katarina,KogMaw,Lilia,Milio,Mordekaiser,Morgana,Nami,Nasus,Neeko,Nilah,Nomsy,Norra,Nunu,Olaf,Poppy,Rakan,Rumble,Ryze,Seraphine,Shen,Shyvana,Smolder,Soraka,Swain,Syndra,Kench,Taric,Tristana,Twitch,Varus,Veigar,Vex,Warwick,Xerath,Ziggs,Zilean,Zoe};

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Arcana",2);
        hm.put("Chrono",2);
        hm.put("Dragon",2);
        hm.put("Eldritch",3);
        hm.put("Faerie",2);
        hm.put("Frost",3);
        hm.put("Honeymancy",3);
        hm.put("Portal",3);
        hm.put("Pyro",2);
        hm.put("Sugarcraft",2);
        hm.put("Witchcraft",2);
        hm.put("Bastion",2);
        hm.put("Blaster",2);
        hm.put("Hunter",2);
        hm.put("Incantor",2);
        hm.put("Mage",3);
        hm.put("Multistriker",3);
        hm.put("Preserver",2);
        hm.put("Scholar",2);
        hm.put("Shapeshifter",2);
        hm.put("Vanguard",2);
        hm.put("Warrior",2);

        TFT tft = new TFT(units,hm);
        int [] solution= tft.maxStandUnited(4);

        if(solution.length==0)
            System.out.println("No non-unique trait can be activated using that many units!");
        else {
            for (int i : solution) {
                System.out.print(units[i] + " ");
            }
        }
    }
}
class Unit{
    String [] traits;
    String name;

    public Unit(String [] traits, String name){
        this.traits= traits;
        this.name= name;
    }

    public String toString(){
        return this.name;
    }
}
