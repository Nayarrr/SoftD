package fr.polymontp.Rayan.entreprise;

import java.io.IOException;
import java.lang.Throwable; 

public class Paie{
    public static void main(String[] args){
        Commercial c1 = new Commercial("kiki");
        Commercial c2 = new Commercial("kaka");
        Commercial c3 = new Commercial("koko");
        Commercial c4 = new Commercial("keke", 1300, 300 );
        EmployeTaux e5 = new EmployeTaux("haha");
        EmployeTaux e6 = new EmployeTaux("hihi", 45, 50, 10);
        Employe e = new EmployeTaux("huhu");
        Employe[] tableau = {c1,c2,c3,c4,e5,e6,e};
        e5.setInfosSalaire(30,28, 10);
        c1.setInfosSalaire(1600, 1900);
        
        for (Employe i : tableau){
            System.out.println(i.getName() + " gagne " + i.getSalaire() + "€");
        }

        double caHebdo = 0;
        for (Employe i : tableau){
            if (i instanceof Commercial){
                caHebdo += ((Commercial) i).getCA();
            }
        };

        Directeur theBoss = Directeur.creerDirecteur("boss", caHebdo, 0.4, 3000);
        System.out.println(tableau.length);
        tableau[tableau.length - 1] = theBoss;

        Entreprise ent = new Entreprise(3);
    
        try{
            ent.addEmploye(c1);
        }
        catch(MaxCommercialException m){
            System.err.println("Trop de commercial force a lui pour trouver une nouvelle entreprise !");
            m.printStackTrace();
        }

        try{
            ent.addEmploye(c2);
        }
        catch(MaxCommercialException m){
            System.err.println("Trop de commercial force a lui pour trouver une nouvelle entreprise !");
            m.printStackTrace();
        }

        try{
            ent.addEmploye(c3);
        }
        catch(MaxCommercialException m){
            System.err.println("Trop de commercial force a lui pour trouver une nouvelle entreprise !");
            m.printStackTrace();
        }

        try{
            c1.enregistreToi();
            c2.enregistreToi();
            c1.enregistreToiBinaire();
        }
        catch(Exception f){
            System.err.println("Je ne peux pas ouvrir le fichier");
        }
        

        try {
            System.out.println(c1.Lire(c1.getName() + "Comm.txt"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            System.out.println(c1.lireToiBinaire(c1.getName() + "Data.txt"));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}