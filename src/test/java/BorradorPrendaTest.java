import domain.prenda.CampoNoIngresadoException;
import domain.prenda.Categoria;
import domain.prenda.Color;
import domain.prenda.BorradorPrenda;
import domain.prenda.Formalidad;
import domain.prenda.Prenda;
import domain.prenda.Tela;
import domain.prenda.Tipo;
import domain.Usuario;
import org.junit.Before;
import org.junit.Test;

public class BorradorPrendaTest {
  private BorradorPrenda prendaB;
  private Tipo tipo;
  private Tela tela;

  @Before
  public void init(){
    tipo = new Tipo("deInvierno", Categoria.CALZADO, 20);
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

  /*@Test
  public void chequeoStatic(){
    Usuario usu = new Usuario(20);

    Tipo tipoS = new Tipo("deInvierno", Categoria.PARTESUPERIOR, 20);
    Tela telaS = new Tela();
    BorradorPrenda prendaBS = new BorradorPrenda(tipoS);
    prendaBS.conTela(telaS);
    prendaBS.conColorPrimario(Color.GRIS);
    prendaBS.conFormalidad(Formalidad.INFORMAL);
    Prenda prendaSup = prendaBS.guardarPrenda();

    Tipo tipoI = new Tipo("deInvierno", Categoria.PARTEINFERIOR, 20);
    Tela telaI = new Tela();
    BorradorPrenda prendaBI = new BorradorPrenda(tipoI);
    prendaBI.conTela(telaI);
    prendaBI.conColorPrimario(Color.GRIS);
    prendaBI.conFormalidad(Formalidad.INFORMAL);
    Prenda prendaInf = prendaBI.guardarPrenda();

    Tipo tipoC = new Tipo("deInvierno", Categoria.CALZADO, 20);
    Tela telaC = new Tela();
    BorradorPrenda prendaBC = new BorradorPrenda(tipoC);
    prendaBC.conTela(telaC);
    prendaBC.conColorPrimario(Color.GRIS);
    prendaBC.conFormalidad(Formalidad.INFORMAL);
    Prenda prendaCal = prendaBC.guardarPrenda();

    usu.agregarPrenda(prendaSup);
    usu.agregarPrenda(prendaInf);
    usu.agregarPrenda(prendaCal);

    usu.obtenerSugerencias().forEach(sug -> System.out.println(sug.getSugerencia()));
  }*/
}
