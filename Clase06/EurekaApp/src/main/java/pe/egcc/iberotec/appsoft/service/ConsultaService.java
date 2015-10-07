package pe.egcc.iberotec.appsoft.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.iberotec.appsoft.model.ClienteBean;
import pe.egcc.iberotec.appsoft.mybatis.espec.ClienteMapper;
import pe.egcc.iberotec.appsoft.mybatis.espec.ConsultaMapper;

@Service
public class ConsultaService {

  @Autowired
  private ConsultaMapper consultaMapper;
  
  @Autowired
  private ClienteMapper clienteMapper;
  
  public List<Map<String,Object>> obtenerResumen() {
    return consultaMapper.obtenerResumen();
  }
  
  public List<Map<String,Object>> obtenerMovimientos(String cuenta) {
    return consultaMapper.obtenerMovimientos(cuenta);
  }

  public List<ClienteBean> obtenerClientes(ClienteBean clienteBean){
    clienteBean.setVacios();
    return clienteMapper.getClientes(clienteBean);
  }
}
