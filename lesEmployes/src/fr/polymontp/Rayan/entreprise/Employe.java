package lesEmployes.src.fr.polymontp.Rayan.entreprise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Employe implements Comparable{
    public String name;
    
    public abstract double getSalaire();

    public String getName(){
        return this.name;
    }

    public Employe(String name){
        this.name = name;
    }

    public String Lire(String file) throws IOException{
        try{
            BufferedReader in = new BufferedReader(new FileReader(file));
            String res = new String();
            String reader = new String();

            while((reader = in.readLine()) != null){
                res += reader + " ";
            }
            in.close();
            return res;
        }
        catch(Exception e){
            return "Je ne trouve pas le fichier";
        }
    }

    public int compareTo(Object emp){
        return this.name.compareTo(((Employe) emp).name);
    }
}