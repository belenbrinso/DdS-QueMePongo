package domain;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  protected List<Prenda> prendas = new ArrayList();

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }

  public List<Prenda> getPrendas(){
    return prendas;
  }
}