package domain;

import domain.prenda.Prenda;

public class SolicitudAgregarPrenda extends Solicitud {

  public SolicitudAgregarPrenda(Prenda prenda, Guardarropas guardarropas) {
    super(prenda, guardarropas);
  }

  @Override
  public void aplicarCambio() {
    getGuardarropas().agregarPrenda(getPrenda());
  }
}
