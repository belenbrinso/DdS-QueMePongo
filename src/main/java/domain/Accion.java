package domain;

import java.util.List;

public interface Accion {
 void activar(Usuario usuario, List<Alerta> alertas);
}
