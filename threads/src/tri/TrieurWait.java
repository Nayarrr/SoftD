public class TrieurWait extends Thread {

  private int[] t; // tableau � trier
  private int debut, fin; // tranche de ce tableau qu'il faut trier
  public int count;
  public TrieurWait father;

  public TrieurWait(int [] t, int debut, int fin, int count, TrieurWait father){ //Constructeur des enfants 
    this.t=t;
    this.debut = debut;
    this.fin = fin;
    this.count = count;
    this.father = father;
  }

  public TrieurWait(int [] t){ //constructeur du trieur principal
    this.t = t;
    this.debut = 0;
    this.fin = t.length - 1;
    this.count = 0;
    this.father = null;
  }


  public void run() {
    if (fin - debut < 2) {
        // Cas de base : 1 ou 2 éléments
        if (debut < fin && t[debut] > t[fin]) {
            // Échanger les éléments
            int temp = t[debut];
            t[debut] = t[fin];
            t[fin] = temp;
        }
    } else {
        // Cas récursif : diviser et conquérir
        int milieu = (debut + fin) / 2;
        
        // Créer deux threads pour trier les deux moitiés
        TrieurWait trieur1 = new TrieurWait(t, debut, milieu, this.count, this);
        TrieurWait trieur2 = new TrieurWait(t, milieu + 1, fin,this.count, this);
        
        // Lancer les threads
        trieur1.start();
        trieur2.start();

        synchronized(this){
            while(count < 2){
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                  System.out.println("Thread interrompu");
                }
            }
        } 
        triFusion(debut, fin);
    }
    if (this.father != null) {
      synchronized(this.father){
        this.father.count ++;
        this.father.notify();
      }
    }
  }

  private void triFusion(int debut, int fin) {
    int[] tFusion = new int[fin - debut + 1];
    int milieu = (debut + fin) / 2;
    int i1 = debut, 
        i2 = milieu + 1;
    int iFusion = 0;
    while (i1 <= milieu && i2 <= fin) {
      if (t[i1] < t[i2]) {
        tFusion[iFusion++] = t[i1++];
      }
      else {
        tFusion[iFusion++] = t[i2++]; 
      }
    }
    if (i1 > milieu) {
      for (int i = i2; i <= fin; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    else {
      for (int i = i1; i <= milieu; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    for (int i = 0, j = debut; i <= fin - debut; ) {
      t[j++] = tFusion[i++];
    }
  }
  public static void main(String[] args) {
    int[] t = {5, 8, 3, 2, 7, 10, 1};

    System.out.println("Tableau initial :");
    for (int i = 0; i <t.length; i++) {
      System.out.print(t[i] + " ; ");
    }

    TrieurWait trieur = new TrieurWait(t);
    trieur.start();

    try{
        trieur.join();
    }
    catch (InterruptedException e){
        Thread.currentThread().interrupt();
    }

    System.out.println(" \nTableau trié :");
    for (int i = 0; i < t.length; i++) {
        System.out.print(t[i] + " ; ");
    }
    
    System.out.println();
  }
}
