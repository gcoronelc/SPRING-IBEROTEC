package pe.egcc.iberotec.mybatis.espec;

import java.util.List;

import pe.egcc.iberotec.app.model.ClienteBean;

public interface ClienteMapper {
  
  List<ClienteBean> getTodos();
  
  List<ClienteBean> getClientes(ClienteBean clienteBean);

}
