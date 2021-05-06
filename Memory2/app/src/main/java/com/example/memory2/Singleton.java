package com.example.memory2;

public class Singleton {

  private static Singleton istance = null;
  private Tessera t1, t2;

  private Singleton () {}

  public static Singleton getIstance() {
    if(istance == null) {
      istance = new Singleton();
    }
    return istance;
  }

  public void setTessera(Tessera t) {
    // Se non ho girato neanche una tessera
    if(t1 == null && t2 == null) {
      // Assegno la tessera al primo posto
      t1 = t;
    }
    if (t1 != null && t2 == null) {
      t2 = t;
    }
    if(t1 != null && t2 != null) {
      if(t1.equals(t2)) {
        t1.trovata();
        t2.trovata();
        // Risetto a null
        t1 = null;
        t2 = null;
      } else {
          t1.nonTrovata();
          t2.nonTrovata();
          t1 = null;
          t2 = null;
        }
    }
  }

}