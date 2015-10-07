package pe.egcc.iberotec.appsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.iberotec.appsoft.model.ClienteBean;
import pe.egcc.iberotec.appsoft.service.ConsultaService;

@Controller
public class ClienteController {
  
  @Autowired
  private ConsultaService consultaService;

  @RequestMapping(value="clienteConsultar",method=RequestMethod.POST)
  public ModelAndView clienteConsultar(
      @ModelAttribute ClienteBean clienteBean
      ){
    ModelAndView view = new ModelAndView("listaClientes");
    view.addObject("lista", consultaService.obtenerClientes(clienteBean));
    return view;
  }
  
}
