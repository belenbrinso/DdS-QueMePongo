package domain.clima;

import domain.clima.Clima;
import java.time.LocalDateTime;

public class RespuestaMeteorologica {
  private Clima clima;
  private LocalDateTime expiracion;

  public RespuestaMeteorologica(Clima clima, LocalDateTime expiracion) {
    this.clima = clima;
    this.expiracion = expiracion;
  }

  public boolean expiro() {
    return expiracion.isBefore(LocalDateTime.now());
  }

  public Clima getClima() { return clima; }
}
