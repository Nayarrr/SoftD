public class compteurRunnable implements Runnable{
    public String nom;
    public int maxNbr;

    public compteurRunnable(String nom, int maxNbr){
        this.nom = nom;
        this.maxNbr = maxNbr;
    }

    public String getNom() {
        return nom;
    }
    public int getMaxNbr() {
        return maxNbr;
    }

    public void run(){
        for (int i = 1; i <= maxNbr; i++) {
            System.out.println(nom + " : " + i);
            int pause = (int)(Math.random() * 1000);
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.nom + " a fini de compter jusqu'à " + this.maxNbr);
    }

    public static void main(String[] args) {
        compteurRunnable c1 = new compteurRunnable("Compteur 1", 10);
        compteurRunnable c2 = new compteurRunnable("Compteur 2", 10);
        compteurRunnable c3 = new compteurRunnable("Compteur 3", 10);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2); 
        Thread t3 = new Thread(c3);
        t1.start();
        t2.start();
        t3.start();
    }

}
