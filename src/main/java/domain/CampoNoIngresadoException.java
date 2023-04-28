package domain;

public class CampoNoIngresadoException extends RuntimeException {
  public CampoNoIngresadoException(String mensaje) {
    super(mensaje);
  }
}
