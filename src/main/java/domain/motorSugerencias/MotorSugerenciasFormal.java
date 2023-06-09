package domain.motorSugerencias;

import domain.Atuendo;
import domain.Usuario;
import domain.motorSugerencias.MotorSugerencias;
import domain.prenda.Formalidad;
import domain.prenda.Prenda;
import java.util.List;
import java.util.function.Predicate;

public class MotorSugerenciasFormal implements MotorSugerencias {

  @Override
  public List<Atuendo> aplicarSugerencias(List<Atuendo> atuendos, Usuario usuario) {
    Predicate<Prenda> criterio = (prenda) -> prenda.getFormalidad() != Formalidad.INFORMAL;

    return usuario.getEdad() > 55 ?
        atuendos.stream().filter(a -> a.todasSusPrendasSon(criterio)).toList()
        : atuendos;
  }
}
