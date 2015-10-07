package pe.egcc.iberotec.appsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.iberotec.appsoft.model.ClienteBean;
import pe.egcc.iberotec.appsoft.service.ConsultaService;

@Controller
public class ConsultaController {

  @Autowired
  private ConsultaService consultaService;
  
  @RequestMapping(value="verResumenMov.htm", method=RequestMethod.GET)
  public ModelAndView verResumenMov(){
    ModelAndView mav = new ModelAndView("resumen");
    mav.addObject("resumen", consultaService.obtenerResumen());
    return mav;
  }
  
  @RequestMapping(value="verMovimientos.htm", method=RequestMethod.POST)
  public ModelAndView verMovimientos(
      @RequestParam("cuenta") String cuenta
      ){
    ModelAndView mav = new ModelAndView("movimientos");
    mav.addObject("lista", consultaService.obtenerMovimientos(cuenta));
    return mav;
  }
  
  @RequestMapping(value="verClientes.htm", method=RequestMethod.POST)
  public ModelAndView verClientes(
      @ModelAttribute ClienteBean clienteBean
      ){
    ModelAndView mav = new ModelAndView("conClientes");
    mav.addObject("lista", consultaService.obtenerClientes(clienteBean));
    return mav;
  }
  
  
  
}
