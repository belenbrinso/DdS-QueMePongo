package domain;
import java.util.Arrays;
import java.util.List;

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
    this.categoria = categoria;
  }

  private void chequearCamposIngresados(String tela, String colorPrimario, Tipo tipo, Categoria categoria) {
    List campos = Arrays.asList(tela, colorPrimario, tipo, categoria);
    if (campos.stream().anyMatch(campo -> campo==null)){
      throw new CamposIngresadosIncompletosException();
    }
  }

  public void setColorSecundario(String colorSecundario){
    this.colorSecundario = colorSecundario;
  }
}