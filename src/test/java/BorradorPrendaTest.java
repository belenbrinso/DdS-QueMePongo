import domain.CampoNoIngresadoException;
import domain.Categoria;
import domain.Color;
import domain.BorradorPrenda;
import domain.Formalidad;
import domain.Tela;
import domain.Tipo;
import org.junit.Before;
import org.junit.Test;

public class BorradorPrendaTest {
  private BorradorPrenda prendaB;
  private Tipo tipo;
  private Tela tela;

  @Before
  public void init(){
    tipo = new Tipo("deInvierno", Categoria.CALZADO);
    tela = new Tela();
    prendaB = new BorradorPrenda(tipo);
  }

  @Test(expected = CampoNoIngresadoException.class)
  public void noSePuedeGuardarUnaPrendaSiLaConfiguracionNoEstaCompleta(){
    prendaB.conTela(tela);
    prendaB.guardarPrenda();
  }

  @Test
  public void sePuedeGuardarUnaPrendaQueNoTengaColorSecundario(){
    prendaB.conTela(tela);
    prendaB.conColorPrimario(Color.GRIS);
    prendaB.conFormalidad(Formalidad.INFORMAL);
    prendaB.guardarPrenda();
  }
}
