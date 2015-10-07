package pe.egcc.iberotec.appsoft.mybatis.espec;

import pe.egcc.iberotec.appsoft.model.CuentaBean;
import pe.egcc.iberotec.appsoft.model.MovimientoBean;

public interface CuentaMapper {

  CuentaBean obtenerCuenta(String cuenta);
  
  void actualizarCuenta(CuentaBean cuentaModel);
  
  void registrarMovimiento(MovimientoBean movimientoModel);
  
}
