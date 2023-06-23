package domain;

import domain.clima.Clima;
import domain.clima.ServicioMeteorologico;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioClima {
  private static final RepositorioClima instance = new RepositorioClima();
  private ServicioMeteorologico servicioMeteorologico;
  private Map<String, List<Alerta>> alertasActuales = new HashMap<>();

  private RepositorioClima() {}
  public static RepositorioClima get() { return instance; }

  public Clima consultarClima(String direccion) {
    return servicioMeteorologico.obtenerCondicionesClimaticas(direccion);
  }

  public void actualizarAlertas() {
    RepositorioUsuarios.get().getUsuarios().forEach(usuario -> {
      String direccion = usuario.getDireccionActual();
      alertasActuales.put(direccion, servicioMeteorologico.obtenerAlertas(direccion));
      if(!alertasActuales.get(direccion).isEmpty())
        usuario.recibirAlerta(alertasActuales.get(direccion));
    });
  }

  public List<Alerta> consultarAlertas(String direccion) {
    return alertasActuales.get(direccion);
  }

  public void setServicioMeteorologico(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

}
