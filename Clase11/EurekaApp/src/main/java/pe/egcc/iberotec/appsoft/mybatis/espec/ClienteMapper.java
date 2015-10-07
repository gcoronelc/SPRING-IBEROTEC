package pe.egcc.iberotec.appsoft.mybatis.espec;

import java.util.List;
import java.util.Map;

import pe.egcc.iberotec.appsoft.model.ClienteBean;


public interface ClienteMapper {
  
  List<ClienteBean> getTodos();
  
  List<ClienteBean> getClientes(ClienteBean clienteBean);
  
  ClienteBean getCliente(String codigo);
  
  void modificar(ClienteBean clienteBean);
  
  Map<String, Object> getContador();
  
  void actcontador(int contador);
  
  void insertar(ClienteBean clienteBean);

}
