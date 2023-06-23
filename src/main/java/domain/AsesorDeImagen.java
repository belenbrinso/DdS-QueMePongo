package domain;

import domain.clima.Clima;
import domain.motorSugerencias.MotorSugerencias;
import java.util.List;
import java.util.Optional;

public class AsesorDeImagen {
  private MotorSugerencias motorSugerencias;

  public AsesorDeImagen(MotorSugerencias motorSugerencias){
    this.motorSugerencias = motorSugerencias;
  }

  public Atuendo sugerirAtuendo(Usuario usuario) {
    Clima clima = RepositorioClima.get().consultarClima(usuario.getDireccionActual());
    List<Atuendo> combinaciones = usuario.getAtuendos();
    List<Atuendo> combConSug = motorSugerencias.aplicarSugerencias(combinaciones, usuario);
    Optional<Atuendo> atuendo = combConSug.stream()
        .filter(comb -> comb.aptaParaTemperatura(clima.getTemperatura())).findFirst();
    if(atuendo.isEmpty())
      throw new RuntimeException("El usuario no posee un atuendo que cumpla con las condiciones especificadas");
    return atuendo.get();
  }

}


