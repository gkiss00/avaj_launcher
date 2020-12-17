import java.util.Scanner;

import java.io.File;

public class Simulation{
    static private int nb_turn = 0;
    static private Flyable[] flyables = new Flyable[0];
    static private final WeatherTower weatherTower = new WeatherTower();

    private static void addNewCraft(Flyable flyable){
        Flyable[] tmp = new Flyable[flyables.length + 1];
        for (int i = 0; i < flyables.length; ++i){
            tmp[i] = flyables[i];
        }
        tmp[flyables.length] = flyable;
        flyables = tmp;
    }

    private static void createNewCraft(String line){
        AircraftFactory af = new AircraftFactory();
        String args[] = line.split("\\s+");
        Flyable tmp = af.newAircraft(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        addNewCraft(tmp);
    }

    private static void setNbTurn(String line){
        nb_turn = Integer.parseInt(line);
    }

    private static void startSimulation(){
        for (int i = 0; i < flyables.length; ++i){
            flyables[i].registerTower(weatherTower);
        }
        for (int i = 0; i < nb_turn; ++i){
            for(int j = 0; j < flyables.length; ++j){
                flyables[j].updateConditions();
            }
        }
    }

    public static void main(String []args){
        try {
            if (args.length == 0)
                throw (new NoArgsException("No agr get passed to the program"));
            if (args.length > 1)
                throw (new ToMuchArgsException("To much args get passed to the program"));
            File f = new File(args[0]);
            if(!f.exists())
                throw (new FileException("File \"" + args[0] + "\" doesn't exists"));
            Scanner scan = new Scanner(f);
            int nb_line = 1;

            while(scan.hasNextLine()){
                if (nb_line == 1)
                    setNbTurn(scan.nextLine());
                else
                    createNewCraft(scan.nextLine());
                ++nb_line;
            }
            startSimulation();
            System.out.println("Fin de la simulation");
        }catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
    }
}