package pe.egcc.iberotec.appsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.iberotec.appsoft.model.CuentaBean;
import pe.egcc.iberotec.appsoft.model.MovimientoBean;
import pe.egcc.iberotec.appsoft.mybatis.espec.CuentaMapper;

@Service
public class CuentaService {

  @Autowired
  private CuentaMapper cuentaMapper;

  @Transactional(propagation = Propagation.REQUIRES_NEW, 
      rollbackFor = Exception.class, 
      isolation = Isolation.REPEATABLE_READ)
  public void registrarDeposito(String cuenta, double importe, String empleado) {
    // Datos de la cuenta
    CuentaBean cuentaModel = cuentaMapper.obtenerCuenta(cuenta);
    if(cuentaModel == null){
     throw new RuntimeException("Cuenta no existe.");
    }
    try {
      Thread.currentThread().sleep(1000);
    } catch (Exception e) {
    }
    // Actualizar datos de la cuenta
    int contmov = cuentaModel.getContmov() + 1;
    cuentaModel.setCuensaldo(cuentaModel.getCuensaldo() + importe);
    cuentaModel.setContmov(contmov);
    cuentaMapper.actualizarCuenta(cuentaModel);
    // Registrar movimiento
    MovimientoBean movimientoModel = new MovimientoBean();
    movimientoModel.setCuencodigo(cuentaModel.getCuencodigo());
    movimientoModel.setMovinumero(contmov);
    movimientoModel.setEmplcodigo(empleado);
    movimientoModel.setTipocodigo("003");
    movimientoModel.setMoviimporte(importe);
    movimientoModel.setReferencia(null);
    cuentaMapper.registrarMovimiento(movimientoModel);
  }

}
