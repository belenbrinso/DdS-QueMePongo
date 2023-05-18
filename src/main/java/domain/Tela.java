package domain;
import static domain.Trama.LISA;

public class Tela{
  private Trama trama;

  public Tela(Trama trama) {
    this.trama = trama;
  }
  public Tela() { this(LISA); }
}