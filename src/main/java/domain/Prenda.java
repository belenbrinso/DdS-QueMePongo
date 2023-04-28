package domain;

public class Prenda {
  private Tipo tipo;
  private Tela tela;
  private Color colorPrimario;
  private Color colorSecundario;

  public Prenda(Tipo tipo, Tela tela, Color colorPrimario, Color colorSecundario) {
    this.tipo = tipo;
    this.tela = tela;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
  }

  public Categoria getCategoria() {return tipo.getCategoria();}
}