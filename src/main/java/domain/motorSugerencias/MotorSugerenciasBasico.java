package domain.motorSugerencias;

import domain.Atuendo;
import domain.Usuario;
import domain.motorSugerencias.MotorSugerencias;
import java.util.List;

public class MotorSugerenciasBasico implements MotorSugerencias {

  @Override
  public List<Atuendo> aplicarSugerencias(List<Atuendo> atuendos, Usuario usuario) {
    return atuendos;
  }
}
