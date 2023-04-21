package domain;

import java.util.ArrayList;

public class Atuendo {
  private ArrayList<Prenda> prendas;

  public Atuendo(ArrayList<Prenda> prendas) {
    this.prendas = prendas;
  }

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }
}
