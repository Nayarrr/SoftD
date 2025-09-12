package fr.polymontp.Rayan.entreprise;

public class EmployeTaux extends Employe{
    public double heureTr;
    public double taux; //pour 30% cela s'ecrira 1.3
    public double tarif;

    public EmployeTaux(String name, int heureTr, int taux, double tarif){
        super(name);
        this.heureTr = heureTr;
        this.taux = taux;
        this.tarif = tarif;
    }

    public EmployeTaux(String name){
        super(name);
    }

    public double getSalaire(){
        if (this.heureTr > 35){
            return 35* this.tarif + (this.heureTr - 35)* this.tarif*this.taux;
        }
        else{
            return this.heureTr * this.tarif;
        }
    }

    public void setInfosSalaire(int taux, int heureTr, double tarif){
        this.taux = taux;
        this.heureTr = heureTr;
        this.tarif = tarif;
    }
}