import model.*;
import exception.*;
import md5.*;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;

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

    private static void createNewCraft(String line) throws Exception{
        AircraftFactory af = new AircraftFactory();
        String args[] = line.split("\\s+");
        String type = args[0];
        String name = args[1];
        int lo = Integer.parseInt(args[2]);
        int la = Integer.parseInt(args[3]);
        int h = Integer.parseInt(args[4]);

        if (lo < 0 || la < 0 || h < 0 || h > 100)
            throw new BadValueException("Bad value input in text file, values must be positive");
        Flyable tmp = af.newAircraft(type, name, lo, la, h);
        if (tmp != null)
            addNewCraft(tmp);
        else
            throw (new AircraftException("There is no aircraft of this type : " + args[0]));
    }

    private static void setNbTurn(String line) throws Exception{
        if (Integer.parseInt(line) < 0)
            throw new BadValueException("Bad value input in text file, nb of turns must be positive");
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
            //Uncomment to encrypt your file with MD5
            Encryptor en = new Encryptor();
            en.encrypt(f, args[0]);
            if (args[0].contains("md5")){
                Descryptor d = new Descryptor();
                f = d.decrpyt(f, args[0]);
            }
            Scanner scan = new Scanner(f);
            int nb_line = 1;

            while(scan.hasNextLine()){
                if (nb_line == 1)
                    setNbTurn(scan.nextLine());
                else
                    createNewCraft(scan.nextLine());
                ++nb_line;
            }
            System.setOut(new PrintStream(new FileOutputStream(new File("simulation.txt"))));
            startSimulation();
            System.out.println("Fin de la simulation");
        }catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
    }
}