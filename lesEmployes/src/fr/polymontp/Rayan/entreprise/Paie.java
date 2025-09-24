package lesEmployes.src.fr.polymontp.Rayan.entreprise;

import java.io.IOException;
import java.lang.Throwable; 
import java.util.Iterator;

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

        Entreprise ent = new Entreprise("LuffyMC",3);
        Entreprise ent2 = new Entreprise("NabilIndustries", 4);
        try{
            ent.addEmploye(c1);
        }
        catch(MaxCommercialException m){
            System.err.println("Trop de commercial force a lui pour trouver une nouvelle entreprise !");
            m.printStackTrace();
        }

        try{
            ent.addEmploye(c2);
            ent2.addEmploye(c3);
            ent2.addEmploye(e);
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

        System.out.println("on a : " + ent.getLenght());

        try{
            ent.removeEmploye(c2);
        }
        catch(NotExistException m){
            System.err.println("Il existe pas");
            m.printStackTrace();
        }

        System.out.println("on a : " + ent.getLenght());

        System.out.println(ent.toString());
        System.out.println(ent2.toString());

        Iterator it = ent.iterEmployes();
        Iterator it2 = ent2.iterEmployes();

        double num = 0;
        double num2 = 0;

        while (it.hasNext()){
            num += ((Employe)it.next()).getSalaire();
        }
        
        while (it2.hasNext()){
            num2 += ((Employe)it2.next()).getSalaire();
        }

        System.out.println(ent.getName() + " a pour masse salariale : " + num);
        System.out.println(ent2.getName() + " a pour masse salariale : " + num2);

        ent.trierAlphabetiquement();
        System.out.println(ent.toString());
        ent2.trierAlphabetiquement();
        System.out.println(ent2.toString());
    }
}