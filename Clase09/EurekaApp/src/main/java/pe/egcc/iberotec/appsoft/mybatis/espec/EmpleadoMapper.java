package pe.egcc.iberotec.appsoft.mybatis.espec;

import org.apache.ibatis.annotations.Param;

import pe.egcc.iberotec.appsoft.model.EmpleadoBean;

public interface EmpleadoMapper {

  EmpleadoBean validar(
      @Param("usuario") String usuario, 
      @Param("clave") String clave);
  
}
