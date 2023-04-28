package domain;

public class Prenda {
  private Tipo tipo;
  private Tela tela;
  private String colorPrimario;
  private String colorSecundario;

  public Prenda(Tipo tipo, Tela tela, String colorPrimario, String colorSecundario) {
    this.tipo = tipo;
    this.tela = tela;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
  }

  public Categoria getCategoria() {return tipo.getCategoria();}
}