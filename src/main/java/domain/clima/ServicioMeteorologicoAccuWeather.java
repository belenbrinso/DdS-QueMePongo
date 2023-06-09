package domain.clima;

import static domain.clima.Humedad.*;

import domain.clima.AccuWeatherAPI;
import domain.clima.Clima;
import domain.clima.Humedad;
import domain.clima.RespuestaMeteorologica;
import domain.clima.ServicioMeteorologico;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {
  private final AccuWeatherAPI api;
  private final Duration periodoDeValidez;
  private HashMap<String, RespuestaMeteorologica> ultimasRespuestas;

  public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez) {
    this.api = api;
    this.periodoDeValidez = periodoDeValidez;
    this.ultimasRespuestas = new HashMap<>();
  }

  @Override
  public Clima obtenerCondicionesClimaticas(String direccion) {
    if (!ultimasRespuestas.containsKey(direccion) || ultimasRespuestas.get(direccion).expiro()) {
      LocalDateTime expiracion = LocalDateTime.now().plus(periodoDeValidez);
      ultimasRespuestas.put(direccion,
          new RespuestaMeteorologica(consultarApi(direccion), expiracion));
    }
    return ultimasRespuestas.get(direccion).getClima();
  }

  private Clima consultarApi(String direccion) {
    Map<String, Object> respuesta = api.getWeather(direccion).get(0);
    int temperatura = (int) ((HashMap<String, Object>) respuesta.get("Temperature")).get("Value");
    Humedad humedad = (double) respuesta.get("PrecipitationProbability") > 0.8 ? LLUVIOSO : SECO;
    return new Clima(temperatura, humedad);
  }

}

