package domain.clima;

import domain.clima.Clima;

public interface ServicioMeteorologico {
  Clima obtenerCondicionesClimaticas(String direccion);
}

