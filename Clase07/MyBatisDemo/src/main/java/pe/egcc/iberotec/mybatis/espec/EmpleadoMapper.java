package pe.egcc.iberotec.mybatis.espec;

import org.apache.ibatis.annotations.Param;

import pe.egcc.iberotec.app.model.EmpleadoBean;

public interface EmpleadoMapper {

  EmpleadoBean validar(
      @Param("usuario") String usuario, 
      @Param("clave") String clave);
  
}
