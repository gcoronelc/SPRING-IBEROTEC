package pe.egcc.iberotec.appsoft.model;

import java.util.Date;

public class CuentaBean {

  private String cuencodigo;
  private String monecodigo;
  private String sucucodigo;
  private String cliecodigo;
  private String creacuenta;
  private double cuensaldo;
  private Date fechacreacion;
  private String cuenestado;
  private int contmov;

  public CuentaBean() {
  }

  public String getCuencodigo() {
    return cuencodigo;
  }

  public void setCuencodigo(String cuencodigo) {
    this.cuencodigo = cuencodigo;
  }

  public String getMonecodigo() {
    return monecodigo;
  }

  public void setMonecodigo(String monecodigo) {
    this.monecodigo = monecodigo;
  }

  public String getSucucodigo() {
    return sucucodigo;
  }

  public void setSucucodigo(String sucucodigo) {
    this.sucucodigo = sucucodigo;
  }

  public String getCliecodigo() {
    return cliecodigo;
  }

  public void setCliecodigo(String cliecodigo) {
    this.cliecodigo = cliecodigo;
  }

  public String getCreacuenta() {
    return creacuenta;
  }
  
  public void setCreacuenta(String creacuenta) {
    this.creacuenta = creacuenta;
  }

  public double getCuensaldo() {
    return cuensaldo;
  }

  public void setCuensaldo(double cuensaldo) {
    this.cuensaldo = cuensaldo;
  }

  public Date getFechacreacion() {
    return fechacreacion;
  }

  public void setFechacreacion(Date fechacreacion) {
    this.fechacreacion = fechacreacion;
  }

  public String getCuenestado() {
    return cuenestado;
  }

  public void setCuenestado(String cuenestado) {
    this.cuenestado = cuenestado;
  }

  public int getContmov() {
    return contmov;
  }

  public void setContmov(int contmov) {
    this.contmov = contmov;
  }

}
