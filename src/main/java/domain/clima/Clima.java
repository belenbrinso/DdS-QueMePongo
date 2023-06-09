package domain.clima;

public class Clima {
  private int temperatura;
  private Humedad humedad;

  public Clima(int temperatura, Humedad humedad){
    this.temperatura = temperatura;
    this.humedad = humedad;
  }

  public int getTemperatura(){ return temperatura; }
  public Humedad getHumedad(){ return humedad; }
}
