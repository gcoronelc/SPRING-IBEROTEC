package pe.egcc.iberotec.appsoft.model;

import java.util.Date;

public class MovimientoBean {

  private String cuencodigo;
  private int movinumero;
  private Date movifecha;
  private String emplcodigo;
  private String tipocodigo;
  private double moviimporte;
  private String referencia;

  public MovimientoBean() {
  }

  public String getCuencodigo() {
    return cuencodigo;
  }

  public void setCuencodigo(String cuencodigo) {
    this.cuencodigo = cuencodigo;
  }

  public int getMovinumero() {
    return movinumero;
  }
  
  public void setMovinumero(int movinumero) {
    this.movinumero = movinumero;
  }

  public Date getMovifecha() {
    return movifecha;
  }

  public void setMovifecha(Date movifecha) {
    this.movifecha = movifecha;
  }

  public String getEmplcodigo() {
    return emplcodigo;
  }

  public void setEmplcodigo(String emplcodigo) {
    this.emplcodigo = emplcodigo;
  }

  public String getTipocodigo() {
    return tipocodigo;
  }

  public void setTipocodigo(String tipocodigo) {
    this.tipocodigo = tipocodigo;
  }

  public double getMoviimporte() {
    return moviimporte;
  }

  public void setMoviimporte(double moviimporte) {
    this.moviimporte = moviimporte;
  }

  public String getReferencia() {
    return referencia;
  }

  public void setReferencia(String referencia) {
    this.referencia = referencia;
  }

}
