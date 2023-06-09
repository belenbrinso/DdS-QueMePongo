package domain.prenda;

public class Prenda {
  private Tipo tipo;
  private Tela tela;
  private Color colorPrimario;
  private Color colorSecundario;
  private Formalidad formalidad;

  public Prenda(Tipo tipo, Tela tela, Color colorPrimario, Color colorSecundario, Formalidad formalidad) {
    this.tipo = tipo;
    this.tela = tela;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.formalidad = formalidad;
  }

  public Categoria getCategoria() {return tipo.getCategoria();}
  public Formalidad getFormalidad() {return formalidad;}
  public int getTemperaturaMaxima() {return tipo.getTemperaturaMaxima();}

  public boolean aptaParaTemperatura(int temp){
    return temp <= getTemperaturaMaxima();
  }
}