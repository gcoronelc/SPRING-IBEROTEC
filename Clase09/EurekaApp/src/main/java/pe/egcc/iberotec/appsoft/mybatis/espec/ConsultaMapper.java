package pe.egcc.iberotec.appsoft.mybatis.espec;

import java.util.List;
import java.util.Map;

public interface ConsultaMapper {

  List<Map<String,Object>> obtenerResumen();
  
  List<Map<String,Object>> obtenerMovimientos(String cuenta);
  

  
}
