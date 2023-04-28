import domain.CampoNoIngresadoException;
import domain.Categoria;
import domain.Color;
import domain.Prenda;
import domain.PrendaBuilder;
import domain.Tela;
import domain.TelaBuilder;
import domain.Tipo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrendaBuilderTest {
  private PrendaBuilder prendaB;
  private Tipo tipo;
  private Tela tela;

  @Before
  public void init(){
    prendaB = new PrendaBuilder();
    tipo = new Tipo("deInvierno", Categoria.CALZADO);
    tela = new TelaBuilder().guardarTela();
  }

  @Test(expected = CampoNoIngresadoException.class)
  public void noSePuedeEspecificarPrimeroUnCampoQueNoEsTipo(){
    prendaB.conTela(tela);
  }

  @Test(expected = CampoNoIngresadoException.class)
  public void noSePuedeGuardarUnaPrendaSiLaConfiguracionNoEstaCompleta(){
    prendaB.conTipo(tipo);
    prendaB.conTela(tela);
    prendaB.guardarPrenda();
  }

  @Test
  public void sePuedeGuardarUnaPrendaQueNoTengaColorSecundario(){
    prendaB.conTipo(tipo);
    prendaB.conTela(tela);
    prendaB.conColorPrimario(Color.GRIS);
    prendaB.guardarPrenda();
  }
}
