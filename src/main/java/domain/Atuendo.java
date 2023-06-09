package domain;

import domain.prenda.Prenda;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Atuendo {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado){
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
  }

  public List<Prenda> getAtuendo(){
    return Arrays.asList(parteSuperior, parteInferior, calzado);
  }

  public boolean todasSusPrendasSon(Predicate<Prenda> criterio){
    return getAtuendo().stream().allMatch(criterio);
  }

  public boolean aptaParaTemperatura(int temperatura){
    return getAtuendo().stream().allMatch(prenda -> prenda.aptaParaTemperatura(temperatura));
  }
}
