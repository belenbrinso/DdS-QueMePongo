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