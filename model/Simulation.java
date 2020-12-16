import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.io.File;

public class Simulation{
    static private int nb_turn = 0;
    static private final List<Flyable> flyables = new ArrayList<Flyable>();
    static private final WeatherTower weaterTower = new WeatherTower();

    public static void createNewCraft(String line){
        AircraftFactory af = new AircraftFactory();
        String args[] = line.split("\\s+");

        flyables.add(af.newAircraft(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));
    }

    public static void setNbTurn(String line){
        nb_turn = Integer.parseInt(line);
    }

    public static void startSimulation(){
        for (int i = 0; i < flyables.size(); ++i){
            flyables.get(i).registerTower(weaterTower);
        }
        for (int i = 0; i < nb_turn; ++i){
            for(int j = 0; j < flyables.size; ++j){
                
            }
        }
    }

    public static void main(String []args){
        try {
            File f = new File(args[0]);
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
        }catch(Exception e){

        }
    }
}