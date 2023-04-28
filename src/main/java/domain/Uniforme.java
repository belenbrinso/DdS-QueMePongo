package domain;

import static domain.Categoria.ACCESORIO;

public class Uniforme extends Atuendo{
  private String institucion;

  public Uniforme(String institucion){
    this.institucion = institucion;
  }

  @Override
  public void agregarPrenda(Prenda prenda) {
    if (noEsAccesorio(prenda) && noHayPrendaDeSuCategoria(prenda)) prendas.add(prenda);
  }

  private boolean noEsAccesorio(Prenda prenda) {
    return prenda.getCategoria() != ACCESORIO;
  }

  private boolean noHayPrendaDeSuCategoria(Prenda nuevaPrenda) {
    return prendas.stream().allMatch(prendaCargada -> prendaCargada.getCategoria() != nuevaPrenda.getCategoria());
  }
}
