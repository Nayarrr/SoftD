package lesEmployes.src.fr.polymontp.Rayan.entreprise;

public class NotExistException extends Exception{
    private Entreprise e;

    public NotExistException(Entreprise e){
        this.e = e;
    }

    public Entreprise getEntreprise(){
        return this.e;
    }

}