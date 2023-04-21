package domain;

public class CamposIngresadosIncompletosException extends RuntimeException {
  public CamposIngresadosIncompletosException() {
    super("Los campos tela, colorPrimario, tipo y categoría no pueden ser nulos");
  }
}
