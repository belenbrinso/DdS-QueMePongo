package domain;

import domain.prenda.Prenda;
import java.util.ArrayList;
import java.util.List;

public abstract class Solicitud {
  private Prenda prenda;
  private Guardarropas guardarropas;
  private List<Prenda> backupPrendas;

  public Solicitud(Prenda prenda, Guardarropas guardarropas){
    this.prenda = prenda;
    this.guardarropas = guardarropas;
    this.backupPrendas = new ArrayList<>();
  }

  public void guardarBackup(){
    this.backupPrendas = guardarropas.getPrendas();
  }

  public void aceptar(){
    guardarBackup();
    aplicarCambio();
  }

  public void deshacerCambio(){
    guardarropas.setPrendas(backupPrendas);
  }

  public Guardarropas getGuardarropas() { return guardarropas; }
  public Prenda getPrenda() { return prenda; }

  public abstract void aplicarCambio();
}
