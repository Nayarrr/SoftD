package fr.polymontp.Rayan.entreprise;

import java.io.*;

public class Commercial extends Employe{
    public double sommeFixe;
    public double ca;

    public Commercial(String name, double sommeFixe, double ca){
        super(name);
        this.sommeFixe = sommeFixe;
        this.ca = ca;
    }

    public Commercial(String name){
        super(name);
    }

    public double getSalaire(){
        return this.sommeFixe + 0.01*ca;
    }

    public void setInfosSalaire(double sommeFixe, double ca){
        this.sommeFixe = sommeFixe;
        this.ca = ca;
    }

    public double getCA(){
        return this.ca;
    }

    public void enregistreToi() throws Exception{
        try {
            PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(this.name + "Comm.txt")));
            String s = this.getName() + " | " + this.sommeFixe + " | " + this.ca + " | " + this.getSalaire();
            out1.println(s + "\n");
            out1.close();
        }
        catch (Exception e){
            System.err.println("t'es caca");
        }
    }

    public void enregistreToiBinaire() throws Exception{
        try{
            DataOutputStream out2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(this.getName() + "Data.txt")));
            out2.writeUTF(this.getName());
            out2.writeDouble(this.sommeFixe);
            out2.writeDouble(this.ca);
            out2.writeDouble(this.getSalaire());
            out2.close();
        }
        catch(Exception e){
            System.err.println("gros caca sur toi");
        }
    }

    public String lireToiBinaire(String file) throws IOException{
        try{
            DataInputStream in2 = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            // System.out.println(in2.readUTF());
            // System.out.println(in2.readDouble());
            // System.out.println(in2.readDouble());
            // System.out.println(in2.readDouble());
            
            String res = new String();
            res += in2.readUTF() + " ";
            res += in2.readDouble()+ " ";
            res += in2.readDouble()+ " ";
            res += in2.readDouble()+ " ";
            in2.close();
            return res;
        }
        catch(IOException e){
            return "Je ne trouve pas le fichier";
        }
    }
}