package domain;

import domain.clima.Clima;
import domain.clima.ServicioMeteorologico;
import domain.motorSugerencias.MotorSugerencias;
import java.util.List;
import java.util.Optional;

public class AsesorDeImagen {
  private ServicioMeteorologico servicioMeteorologico;
  private MotorSugerencias motorSugerencias;

  public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico, MotorSugerencias motorSugerencias){
    this.servicioMeteorologico = servicioMeteorologico;
    this.motorSugerencias = motorSugerencias;
  }

  public Optional<Atuendo> sugerirAtuendo(String direccion, Usuario usuario) {
    Clima clima = servicioMeteorologico.obtenerCondicionesClimaticas(direccion);
    List<Atuendo> combinaciones = usuario.getAtuendos();
    List<Atuendo> combConSug = motorSugerencias.aplicarSugerencias(combinaciones, usuario);
    return combConSug.stream().filter(comb -> comb.aptaParaTemperatura(clima.getTemperatura())).findFirst();
  }
}


