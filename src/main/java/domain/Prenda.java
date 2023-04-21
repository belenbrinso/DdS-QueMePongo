package domain;
import java.util.ArrayList;

public class Prenda {
  private Tipo tipo;
  private Categoria categoria;
  private String tela;
  private String colorPrimario;
  private String colorSecundario;

  public Prenda(String tela, String colorPrimario, Tipo tipo, Categoria categoria) {
    chequearCamposIngresados(tela, colorPrimario, tipo, categoria);
    this.tela = tela;
    this.colorPrimario = colorPrimario;
    this.tipo = tipo;
    if(tipo.getCategoria() == categoria) {
      this.categoria = categoria;
    } else {
      throw new NoCoincideTipoConCategoriaException("El tipo de esta prenda no pertenece a la categoría " + categoria.name());
    }
  }

  private void chequearCamposIngresados(String tela, String colorPrimario, Tipo tipo, Categoria categoria) {
    ArrayList campos = new ArrayList();
    campos.add(tela);
    campos.add(colorPrimario);
    campos.add(tipo);
    campos.add(categoria);
    if (campos.stream().anyMatch(campo -> campo==null)){
      throw new CamposIngresadosIncompletosException();
    }
  }

  public void setColorSecundario(String colorSecundario){
    this.colorSecundario = colorSecundario;
  }
}

enum Categoria {
  PARTESUPERIOR, PARTEINFERIOR, CALZADO, ACCESORIO
}

class Tipo {
  private String nombre;
  private Categoria categoria;

  public Tipo(String nombre, Categoria categoria) {
    this.nombre = nombre;
    this.categoria = categoria;
  }
  public String getNombre() {
    return nombre;
  }
  public Categoria getCategoria() {
    return categoria;
  }
}

class Atuendo{
  private ArrayList<Prenda> prendas;
  public Atuendo(ArrayList<Prenda> prendas){
    this.prendas = prendas;
  }
  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }
}

class CamposIngresadosIncompletosException extends RuntimeException {
  public CamposIngresadosIncompletosException() {
    super("Los campos tela, colorPrimario, tipo y categoría no pueden ser nulos");
  }
}

class NoCoincideTipoConCategoriaException extends RuntimeException {
  public NoCoincideTipoConCategoriaException(String mensaje){
    super(mensaje);
  }
}