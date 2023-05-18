package domain;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.Collectors;

public class GeneradorSugerencias {
  private Usuario usuario;
  private List<Sugerencia> sugerencias;

  public GeneradorSugerencias(Usuario usuario){
    this.usuario = usuario;
  }

  public List<Prenda> prendasDeCategoria(Categoria categoria){
    return usuario.getPrendas().stream()
        .filter(prenda -> prenda.getCategoria() == categoria)
        .collect(Collectors.toList());
  }

  public void generar(){
    List<Prenda> prendasParteSup = prendasDeCategoria(Categoria.PARTESUPERIOR);
    List<Prenda> prendasParteInf = prendasDeCategoria(Categoria.PARTEINFERIOR);
    List<Prenda> prendasCalzado = prendasDeCategoria(Categoria.CALZADO);

    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasParteSup, prendasParteInf, prendasCalzado);
    this.sugerencias = combinaciones.stream()
        .map(sug -> new Sugerencia(sug.get(0), sug.get(1), sug.get(2)))
        .collect(Collectors.toList());
  }

}
