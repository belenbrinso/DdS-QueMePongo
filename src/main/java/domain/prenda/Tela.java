package domain.prenda;
import static domain.prenda.Trama.LISA;

public class Tela{
  private Trama trama;

  public Tela(Trama trama) {
    this.trama = trama;
  }
  public Tela() { this(LISA); }
}