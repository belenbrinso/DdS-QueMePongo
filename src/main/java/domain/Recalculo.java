package domain;

import java.util.List;

public class Recalculo implements Accion {
  @Override
  public void activar(Usuario usuario, List<Alerta> alertas) {
    usuario.obtenerSugerenciaDiaria();
  }
}
