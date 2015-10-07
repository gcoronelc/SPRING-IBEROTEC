package pe.egcc.iberotec.appsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.iberotec.appsoft.model.EmpleadoBean;
import pe.egcc.iberotec.appsoft.mybatis.espec.EmpleadoMapper;

@Service
public class EmpleadoService {

  @Autowired
  private EmpleadoMapper empleadoMapper;
  
  public EmpleadoBean validar(String usuario, String clave){
    return empleadoMapper.validar(usuario, clave);
  }
  
}
