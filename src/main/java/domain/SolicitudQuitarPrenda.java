package domain;

import domain.prenda.Prenda;

public class SolicitudQuitarPrenda extends Solicitud {
  public SolicitudQuitarPrenda(Prenda prenda, Guardarropas guardarropas) {
    super(prenda, guardarropas);
  }

  @Override
  public void aplicarCambio() {
    getGuardarropas().quitarPrenda(getPrenda());
  }
}
