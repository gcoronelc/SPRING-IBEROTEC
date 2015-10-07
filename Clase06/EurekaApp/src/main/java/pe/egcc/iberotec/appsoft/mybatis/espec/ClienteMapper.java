package pe.egcc.iberotec.appsoft.mybatis.espec;

import java.util.List;

import pe.egcc.iberotec.appsoft.model.ClienteBean;


public interface ClienteMapper {
  
  List<ClienteBean> getTodos();
  
  List<ClienteBean> getClientes(ClienteBean clienteBean);
  
  
  

}
