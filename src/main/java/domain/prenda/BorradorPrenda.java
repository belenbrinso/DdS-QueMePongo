package domain.prenda;

public class BorradorPrenda {
  private Tipo tipo;
  private Tela tela;
  private Color colorPrimario;
  private Color colorSecundario = null;
  private Formalidad formalidad;

  public BorradorPrenda(Tipo tipo){
    this.tipo = tipo;
  }

  public void conTela(Tela tela) {
    this.tela = tela;
  }

  public void conColorPrimario(Color colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void conColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void conFormalidad(Formalidad formalidad) {
    this.formalidad = formalidad;
  }

  public Prenda guardarPrenda() {
    chequearConfiguracionCompleta();
    return new Prenda(tipo, tela, colorPrimario, colorSecundario, formalidad);
  }

  public void chequearConfiguracionCompleta() {
    chequearCampoFueIngresado(tela, "El campo tela no puede ser nulo");
    chequearCampoFueIngresado(colorPrimario, "El campo colorPrimario no puede ser nulo");
    chequearCampoFueIngresado(formalidad, "El campo formalidad no puede ser nulo");
  }

  private void chequearCampoFueIngresado(Object campo, String mensaje) {
    if (campo==null) throw new CampoNoIngresadoException(mensaje);
  }
}