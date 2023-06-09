package domain;

import com.google.common.collect.Lists;
import domain.prenda.Categoria;
import domain.prenda.Prenda;
import java.util.List;

public class Guardarropas {
  private List<Prenda> prendas;

  public Guardarropas(List<Prenda> prendas){
    this.prendas = prendas;
  }

  public List<Prenda> prendasDeCategoria(Categoria categoria){
    return prendas.stream().filter(prenda -> prenda.getCategoria() == categoria).toList();
  }

  public List<Atuendo> generar(){
    List<Prenda> prendasParteSup = prendasDeCategoria(Categoria.PARTESUPERIOR);
    List<Prenda> prendasParteInf = prendasDeCategoria(Categoria.PARTEINFERIOR);
    List<Prenda> prendasCalzado = prendasDeCategoria(Categoria.CALZADO);

    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasParteSup, prendasParteInf, prendasCalzado);
    return combinaciones.stream().map(sug -> new Atuendo(sug.get(0), sug.get(1), sug.get(2))).toList();
  }

  public List<Atuendo> getAtuendos(){ return generar(); }
  public void agregarPrenda(Prenda prenda){ prendas.add(prenda); }
}
