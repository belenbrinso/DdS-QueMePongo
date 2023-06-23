package domain;

import domain.prenda.Prenda;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Usuario {
  private int edad;
  private String mail;
  private String direccionActual;
  private AsesorDeImagen asesor;
  private Atuendo sugerenciaDiaria;
  private List<Accion> acciones;
  private List<Guardarropas> guardarropas;

  public Usuario(int edad, List<Guardarropas> listaGuardarropas, String direccionActual, AsesorDeImagen asesor, String mail) {
    this.edad = edad;
    this.guardarropas = listaGuardarropas;
    this.direccionActual = direccionActual;
    this.asesor = asesor;
    this.acciones = new ArrayList<>();
    this.mail = mail;
  }

  public void obtenerSugerenciaDiaria(){
    this.sugerenciaDiaria = asesor.sugerirAtuendo(this);
  }

  public void recibirAlerta(List<Alerta> alertas) {
    acciones.forEach(accion -> accion.activar(this, alertas));
  }

  public List<Alerta> obtenerUltAlertas() {
    return RepositorioClima.get().consultarAlertas(direccionActual);
  }

  public void agregarAccion(Accion accion) {
    acciones.add(accion);
  }

  public void quitarAccion(Accion accion) {
    acciones.remove(accion);
  }

  /* ENTREGAS ANTERIORES */
  public void recibirSolicitudAgregarEn(String nombre, Prenda prenda){
    Guardarropas guardarropasSeleccionado = getGuardarropasConNombre(nombre);
    guardarropasSeleccionado.agregarSolicitud(new SolicitudAgregarPrenda(prenda, guardarropasSeleccionado));
  }

  public void recibirSolicitudQuitarEn(String nombre, Prenda prenda){
    Guardarropas guardarropasSeleccionado = getGuardarropasConNombre(nombre);
    guardarropasSeleccionado.agregarSolicitud(new SolicitudQuitarPrenda(prenda, guardarropasSeleccionado));
  }

  public void agregarPrenda(Prenda prenda, String nombre) {
    getGuardarropasConNombre(nombre).agregarPrenda(prenda);
  }
  public void agregarPrenda(Prenda prenda) {
    guardarropas.get(0).agregarPrenda(prenda);
  }

  public List<Atuendo> getAtuendos(String nombre){
    return getGuardarropasConNombre(nombre).getAtuendos();
  }
  public List<Atuendo> getAtuendos(){
    return guardarropas.stream().flatMap(g -> g.getAtuendos().stream()).toList();
  }

  public Guardarropas getGuardarropasConNombre(String nombre) {
    Optional<Guardarropas> rdoBusqueda = guardarropas.stream().filter(g -> g.suNombreEs(nombre)).findFirst();
    if(rdoBusqueda.isEmpty())
      throw new IllegalArgumentException("El nombre indicado no corresponde a un guardarropas existente");
    return rdoBusqueda.get();
  }

  public int getEdad() { return edad; }
  public String getDireccionActual() { return direccionActual; }
  public List<Accion> getAcciones() { return acciones; }
  public String getMail() { return mail; }
}

  /*
  - No repito lógica usando un SolicitudBuilder, el cual configuro al recibir la solicitud y al final la creo.
  - No es necesario hacerlo ahora, es un sobrediseño, porque solo tenemos 2 tipos de solicitudes.

  public void recibirSolicitud(String nombre, Prenda prenda, SolicitudBuilder solicitud) {
    Guardarropas guardarropasSeleccionado = getGuardarropasConNombre(nombre);
    solicitud.sobrePrenda(prenda);
    solicitud.enGuardarropas(guardarropasSeleccionado);
    guardarropasSeleccionado.agregarSolicitud(solicitud.crear());
  }
  */