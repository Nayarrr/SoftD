package fr.polymontp.Rayan.entreprise;

import java.util.ArrayList;

public class Entreprise{
    private int numberComm;
    private int numberMaxComm;
    ArrayList<Employe> tabEmployes = new ArrayList<Employe>();

    public Entreprise(int numberMaxComm){
        this.numberMaxComm = numberMaxComm;
    }

    public void addEmploye(Employe employe) throws MaxCommercialException{
        if (employe instanceof Commercial && numberComm < numberMaxComm){
            tabEmployes.add(employe);
            numberComm ++;
        }
        else if (employe instanceof Commercial && numberComm >= numberMaxComm){
            throw new MaxCommercialException(this);
        }
        else {
            tabEmployes.add(employe);
        }
    }














}