package lesEmployes.src.fr.polymontp.Rayan.entreprise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Entreprise{
    private String name;
    private int numberComm;
    private int numberMaxComm;
    private List tabEmployes = new ArrayList();

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
        String result = "";
        for (Object ep : tabEmployes){
            result += "Entreprise : " + this.name + "; Employe : " + ((Employe) ep).getName() + "\n";
        }

        return result;
    }

    public Iterator iterEmployes(){
        return tabEmployes.iterator();
    }

    public String getName(){
        return this.name;
    }

    public List getEmployes(){
        return this.tabEmployes;
    }

    public void trierAlphabetiquement(){
        Collections.sort(this.tabEmployes);
    }
}