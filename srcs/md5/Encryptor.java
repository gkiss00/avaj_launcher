package md5;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class Encryptor {
    public Encryptor(){

    }

    public void encrypt(File f, String file_name) throws Exception{
        Scanner scan = new Scanner(f);
        File fn;
        String content = "";
        String new_file = file_name;
        new_file += ".md5";

        fn = new File(new_file);
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String args[] = line.split("\\s+");
            for (int i = 0; i < args.length; ++i){
                if (i == 1){
                    content += args[i];
                }else{
                    content += getMd5(args[i]);
                }
                if (i != args.length -1)
                    content += " ";
            }
            if (scan.hasNextLine()){
                content += "\n";
            }
        }
        PrintWriter writer = new PrintWriter(fn, "UTF-8");
        writer.print(content);
        writer.close();
    }

    public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
}