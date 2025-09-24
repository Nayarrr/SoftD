package lesEmployes.src.fr.polymontp.Rayan.entreprise;

public class MaxCommercialException extends Exception{
    private Entreprise e;

    public MaxCommercialException(Entreprise e){
        this.e = e;
    }

    public Entreprise getEntreprise(){
        return this.e;
    }

}