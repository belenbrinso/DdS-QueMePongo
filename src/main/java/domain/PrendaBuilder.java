package domain;

public class PrendaBuilder {
  private Tipo tipo;
  private Tela tela;
  private String colorPrimario;
  private String colorSecundario = null;

  private String msjPrimeroTipo = "Al crear una prenda, se debe especificar primero el tipo";

  public void conTipo(Tipo tipo) { this.tipo = tipo; }

  public void conTela(Tela tela) {
    chequearCampoFueIngresado(tipo, msjPrimeroTipo);
    this.tela = tela;
  }

  public void conColorPrimario(String colorPrimario) {
    chequearCampoFueIngresado(tipo, msjPrimeroTipo);
    this.colorPrimario = colorPrimario;
  }

  public void conColorSecundario(String colorSecundario) {
    chequearCampoFueIngresado(tipo, msjPrimeroTipo);
    this.colorSecundario = colorSecundario;
  }

  public Prenda guardarPrenda() {
    chequearCampoFueIngresado(tipo, msjCampoNoNulo("tipo"));
    chequearCampoFueIngresado(tela, msjCampoNoNulo("tela"));
    chequearCampoFueIngresado(colorPrimario, msjCampoNoNulo("colorPrimario"));
    return new Prenda(tipo, tela, colorPrimario, colorSecundario);
  }

  public String msjCampoNoNulo(String nombreCampo) {
    return "El campo " + nombreCampo + " no puede ser nulo";
  }

  private void chequearCampoFueIngresado(Object campo, String mensaje) {
    if (campo==null) throw new CampoNoIngresadoException(mensaje);
  }
}