public class compteurThread extends Thread{
    public String nom;
    public int maxNbr;

    public compteurThread(String nom, int maxNbr){
        this.nom = nom;
        this.maxNbr = maxNbr;
    }

    public String getNom() {
        return nom;
    }
    public int getMaxNbr() {
        return maxNbr;
    }

    @Override
    public void run(){
        for (int i = 1; i <= maxNbr; i++) {
            System.out.println(nom + " : " + i);
            int pause = (int)(Math.random() * 100);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.nom + " a fini de compter jusqu'à " + this.maxNbr);
    }

    public static void main(String[] args) {
        compteurThread c1 = new compteurThread("Compteur 1", 10);
        compteurThread c2 = new compteurThread("Compteur 2", 10);
        compteurThread c3 = new compteurThread("Compteur 3", 10);

        c1.start();
        c2.start();
        c3.start();
    }





}
