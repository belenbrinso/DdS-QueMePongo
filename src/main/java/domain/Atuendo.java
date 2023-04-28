package domain;

import java.util.ArrayList;

public class Atuendo {
  protected ArrayList<Prenda> prendas = new ArrayList();

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }
}