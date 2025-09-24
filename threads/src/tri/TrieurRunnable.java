public class TrieurRunnable implements Runnable{

  private int[] t; // tableau � trier
  private int debut, fin; // tranche de ce tableau qu'il faut trier

  public TrieurRunnable(int [] t, int debut, int fin){
    this.t=t;
    this.debut = debut;
    this.fin = fin;
  }

  public TrieurRunnable(int [] t){
    this.t = t;
    this.debut = 0;
    this.fin = t.length - 1;
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
        TrieurRunnable trieur1 = new TrieurRunnable(t, debut, milieu);
        TrieurRunnable trieur2 = new TrieurRunnable(t, milieu + 1, fin);
        
        Thread t1 = new Thread(trieur1);
        Thread t2 = new Thread(trieur2);
        // Lancer les threads

        t1.start();
        t2.start();
        
        try {
            // Attendre que les deux threads se terminent
            t1.join();
            t2.join();
            
            // Fusionner les deux moitiés triées
            triFusion(debut, fin);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
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

    TrieurRunnable trieur = new TrieurRunnable(t);
    Thread t3 = new Thread(trieur);
    t3.start();

    try{
        t3.join();
    }
    catch (InterruptedException e){
        Thread.currentThread().interrupt();
    }

    System.out.println("Tableau trié :");
    for (int i = 0; i < t.length; i++) {
        System.out.print(t[i] + " ; ");
    }
    
    System.out.println();
  }

}
