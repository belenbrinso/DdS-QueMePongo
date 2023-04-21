package domain;

public class NoCoincideTipoConCategoriaException extends RuntimeException {
  public NoCoincideTipoConCategoriaException(String mensaje) {
    super(mensaje);
  }
}
