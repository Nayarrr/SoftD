package fr.polymontp.Rayan.entreprise;

public class Directeur extends Employe{
    public double taux;
    public double caHebdo;
    public double sommeFixe;
    private static Directeur leDirecteur;

    private Directeur(String name, double taux, double caHebdo, double sommeFixe){
        super(name);
        this.taux = taux;
        this.caHebdo = caHebdo;
        this.sommeFixe = sommeFixe;
    }

    public static Directeur creerDirecteur(String name, double caHebdo, double taux, double sommeFixe){
        if (leDirecteur == null){
            leDirecteur = new Directeur(name, taux, caHebdo, sommeFixe);
        }
        return leDirecteur;  
    }

    public double getSalaire(){
        return this.sommeFixe + this.taux* this.caHebdo;
    }

}