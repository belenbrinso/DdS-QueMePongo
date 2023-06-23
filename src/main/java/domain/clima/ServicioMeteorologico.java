package domain.clima;

import domain.Alerta;
import java.util.List;

public interface ServicioMeteorologico {
  Clima obtenerCondicionesClimaticas(String direccion);
  List<Alerta> obtenerAlertas(String direccion);
}

