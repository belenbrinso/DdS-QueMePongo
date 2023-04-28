package domain;
import static domain.Trama.LISA;

public class TelaBuilder {
  private Trama trama = LISA;

  public void conTrama(Trama trama) {
    this.trama = trama;
  }

  public Tela guardarTela() {
    return new Tela(trama);
  }
}
