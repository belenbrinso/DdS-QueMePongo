package domain;

import domain.prenda.Prenda;
import java.util.List;

public class Usuario {
  private int edad;
  private Guardarropas guardarropas;

  public Usuario(int edad, Guardarropas guardarropas){
    this.edad = edad;
    this.guardarropas = guardarropas;
  }

  public void agregarPrenda(Prenda prenda) {
    guardarropas.agregarPrenda(prenda);
  }

  public List<Atuendo> getAtuendos(){
    return guardarropas.getAtuendos();
  }
  public int getEdad() { return edad; }

}