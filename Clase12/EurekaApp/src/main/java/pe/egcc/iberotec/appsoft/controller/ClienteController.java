package pe.egcc.iberotec.appsoft.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.iberotec.appsoft.model.ClienteBean;
import pe.egcc.iberotec.appsoft.service.ClienteService;
import pe.egcc.iberotec.appsoft.service.ConsultaService;
import pe.egcc.iberotec.appsoft.util.EurekaUtil;

@Controller
public class ClienteController {
  
  @Autowired
  private ConsultaService consultaService;
  
  @Autowired
  private ClienteService clienteService;

  @RequestMapping(value="clienteConsultar.htm",method=RequestMethod.POST)
  public ModelAndView clienteConsultar(
      @ModelAttribute ClienteBean clienteBean
      ){
    ModelAndView view = new ModelAndView("listaClientes");
    view.addObject("lista", consultaService.obtenerClientes(clienteBean));
    return view;
  }
  
  @RequestMapping(value="clienteNuevo.htm", method=RequestMethod.POST)
  public String clienteNuevo(Model model){
    model.addAttribute("accion", EurekaUtil.CRUD_NUEVO);
    ClienteBean clienteBean = new ClienteBean();
    clienteBean.setCodigo("NONE");
    model.addAttribute("clienteBean", clienteBean);
    return "formCliente";
  }
  
  @RequestMapping(value="clienteEditar.htm", method=RequestMethod.POST)
  public String clienteEditar(@RequestParam("codigo") String codigo, Model model){
    model.addAttribute("accion", EurekaUtil.CRUD_EDITAR);
    ClienteBean clienteBean = clienteService.getCliente(codigo);
    model.addAttribute("clienteBean", clienteBean);
    return "formCliente";
  }
  
  @RequestMapping(value="clienteEliminar.htm", method=RequestMethod.POST)
  public String clienteEliminar(@RequestParam("codigo") String codigo, Model model){
    model.addAttribute("accion", EurekaUtil.CRUD_ELIMINAR);
    ClienteBean clienteBean = clienteService.getCliente(codigo);
    model.addAttribute("clienteBean", clienteBean);
    return "formCliente";
  }
  
  @RequestMapping(value="clienteGrabar.htm", method=RequestMethod.POST,
      produces="application/json")
  @ResponseBody
  public Map<String,Object> clienteGrabar(
      @ModelAttribute ClienteBean clienteBean,
      @RequestParam("accion") String accion
      ){
    Map<String,Object> data = new HashMap<String, Object>();
    try {
      if(accion.equals(EurekaUtil.CRUD_NUEVO)){
        clienteService.insertar(clienteBean);
      } else if(accion.equals(EurekaUtil.CRUD_EDITAR)){
        clienteService.modificar(clienteBean);
      } else if(accion.equals(EurekaUtil.CRUD_ELIMINAR)){
        clienteService.eliminar(clienteBean);
      }
      data.put("code", 1);
      data.put("mensaje", "Proceso ok.");
    } catch (Exception e) {
      data.put("code", 0);
      data.put("mensaje", "ERROR: " + e.getMessage());
    }
    return data;
  }
}
