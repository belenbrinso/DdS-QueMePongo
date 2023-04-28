package domain;

import static domain.Trama.LISA;

public class Tela {
  private Trama trama;

  public Tela(Trama trama) {
    this.trama = trama;
  }
}

class TelaBuilder {
  private Trama trama = LISA;

  public void conTrama(Trama trama) {
    this.trama = trama;
  }
  public Tela guardarTela() {
    return new Tela(trama);
  }
}

enum Trama {
  LISA, RAYADA, CONLUNARES, ACUADROS, ESTAMPADO
}