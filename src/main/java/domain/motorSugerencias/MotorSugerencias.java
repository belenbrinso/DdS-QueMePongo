package domain.motorSugerencias;

import domain.Atuendo;
import domain.Usuario;
import java.util.List;

public interface MotorSugerencias {
  List<Atuendo> aplicarSugerencias(List<Atuendo> atuendos, Usuario usuario);
}
