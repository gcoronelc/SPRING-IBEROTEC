package pe.egcc.iberotec.appsoft.service;

import java.text.DecimalFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.iberotec.appsoft.model.ClienteBean;
import pe.egcc.iberotec.appsoft.mybatis.espec.ClienteMapper;

@Service
public class ClienteService {

  @Autowired
  private ClienteMapper clienteMapper;

  public ClienteBean getCliente(String codigo) {
    return clienteMapper.getCliente(codigo);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, 
      rollbackFor = Exception.class)
  public void insertar(ClienteBean clienteBean) {
    // Contador
    Map<String,Object> contMap = clienteMapper.getContador();
    int cont = Integer.parseInt(contMap.get("int_contitem").toString());
    int ancho = Integer.parseInt(contMap.get("int_contlongitud").toString());
    // Actualizar el contador
    cont++;
    clienteMapper.actcontador(cont);
    // Generar el codigo
    String patron = "";
    for(int i = 1; i <= ancho; i++){
      patron += "0";
    }
    DecimalFormat df = new DecimalFormat(patron);
    String codigo = df.format(cont);
    // Registrar el cliente
    clienteBean.setCodigo(codigo);
    clienteMapper.insertar(clienteBean);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, 
      rollbackFor = Exception.class)
  public void eliminar(ClienteBean clienteBean) {
    
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW, 
      rollbackFor = Exception.class)
  public void modificar(ClienteBean clienteBean) {
    clienteMapper.modificar(clienteBean);
  }
}
