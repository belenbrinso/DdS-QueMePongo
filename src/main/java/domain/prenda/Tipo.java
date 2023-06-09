package domain.prenda;

public class Tipo{
  private String nombre;
  private Categoria categoria;
  private int temperaturaMaxima;

  public Tipo(String nombre, Categoria categoria, int temperaturaMaxima) {
    this.nombre = nombre;
    this.categoria = categoria;
    this.temperaturaMaxima = temperaturaMaxima;
  }

  public String getNombre() {
    return nombre;
  }
  public Categoria getCategoria() {
    return categoria;
  }
  public int getTemperaturaMaxima() { return temperaturaMaxima; }
}
