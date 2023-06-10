package domain;

import com.google.common.collect.Lists;
import domain.prenda.Categoria;
import domain.prenda.Prenda;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Guardarropas {
  private String nombre;
  private List<Usuario> usuarios;
  private List<Prenda> prendas;
  private List<Solicitud> solicitudesPendientes;
  private List<Solicitud> historial;

  public Guardarropas(String nombre, List<Usuario> usuarios, List<Prenda> prendas){
    this.nombre = nombre;
    this.usuarios = usuarios;
    this.prendas = prendas;
    this.solicitudesPendientes = new ArrayList<>();
    this.historial = new ArrayList<>();
  }

  public List<Prenda> prendasDeCategoria(Categoria categoria){
    return prendas.stream().filter(prenda -> prenda.getCategoria() == categoria).toList();
  }

  public List<Atuendo> generar(){
    List<Prenda> prendasParteSup = prendasDeCategoria(Categoria.PARTESUPERIOR);
    List<Prenda> prendasParteInf = prendasDeCategoria(Categoria.PARTEINFERIOR);
    List<Prenda> prendasCalzado = prendasDeCategoria(Categoria.CALZADO);

    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasParteSup, prendasParteInf, prendasCalzado);
    return combinaciones.stream().map(sug -> new Atuendo(sug.get(0), sug.get(1), sug.get(2))).toList();
  }

  public void agregarSolicitud(Solicitud solicitud) {
    solicitudesPendientes.add(solicitud);
  }

  public void aceptarSolicitud(Solicitud solicitud) {
    historial.add(solicitud);
    solicitudesPendientes.remove(solicitud);
    solicitud.aceptar();
  }

  public void rechazarSolicitud(Solicitud solicitud) {
    solicitudesPendientes.remove(solicitud);
  }

  public void deshacerSolicitud(Solicitud solicitud) {
    historial.remove(solicitud);
    solicitud.deshacerCambio();
  }

  public void agregarPrenda(Prenda prenda){ prendas.add(prenda); }
  public void quitarPrenda(Prenda prenda){ prendas.remove(prenda); }

  public List<Atuendo> getAtuendos(){ return generar(); }
  public List<Prenda> getPrendas() { return prendas; }
  public void setPrendas(List<Prenda> prendas) { this.prendas = prendas; }

  public boolean suNombreEs(String nombreConsultado) { return Objects.equals(nombre, nombreConsultado); }
}
