package fr.polymontp.Rayan.entreprise;

import java.util.ArrayList;
import java.util.List;

public class Entreprise{
    public String name;
    private int numberComm;
    private int numberMaxComm;
    List tabEmployes = new ArrayList();

    public Entreprise(String name, int numberMaxComm){
        this.name = name;
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

    public void removeEmploye(Employe e) throws NotExistException{
        if (tabEmployes.contains(e)){
            if (e instanceof Commercial){
                numberComm--;
            }
            tabEmployes.remove(tabEmployes.indexOf(e));
        }
        else{
            throw new NotExistException(this);
        }
    }

    public int getLenght(){
        return tabEmployes.size();
    }

    public String toString(){
        String names = "";
        for (int i = 0; i<= tabEmployes.size(); i++){
            names += ((Employe) tabEmployes[i].getName());
        }
        return "Entreprise : " + this.name + ;
    }
}