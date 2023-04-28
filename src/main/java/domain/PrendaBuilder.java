package domain;

public class PrendaBuilder {
  private Tipo tipo;
  private Tela tela;
  private Color colorPrimario;
  private Color colorSecundario = null;

  public void conTipo(Tipo tipo) { this.tipo = tipo; }

  public void conTela(Tela tela) {
    chequearTipoFueIngresado();
    this.tela = tela;
  }

  public void conColorPrimario(Color colorPrimario) {
    chequearTipoFueIngresado();
    this.colorPrimario = colorPrimario;
  }

  public void conColorSecundario(Color colorSecundario) {
    chequearTipoFueIngresado();
    this.colorSecundario = colorSecundario;
  }

  public Prenda guardarPrenda() {
    chequearConfiguracionCompleta();
    return new Prenda(tipo, tela, colorPrimario, colorSecundario);
  }

  public void chequearTipoFueIngresado() {
    chequearCampoFueIngresado(tipo, "Al crear una prenda, se debe especificar primero el tipo");
  }

  public void chequearConfiguracionCompleta() {
    chequearCampoFueIngresado(tipo, "El campo tipo no puede ser nulo");
    chequearCampoFueIngresado(tela, "El campo tela no puede ser nulo");
    chequearCampoFueIngresado(colorPrimario, "El campo colorPrimario no puede ser nulo");
  }

  private void chequearCampoFueIngresado(Object campo, String mensaje) {
    if (campo==null) throw new CampoNoIngresadoException(mensaje);
  }
}