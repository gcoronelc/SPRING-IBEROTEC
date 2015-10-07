package pe.egcc.iberotec.appsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.iberotec.appsoft.service.CuentaService;

@Controller
public class CuentaController {

  @Autowired
  private CuentaService cuentaService;
  
  @RequestMapping(value="procDeposito.htm", method=RequestMethod.POST)
  public ModelAndView procDeposito(
      @RequestParam("cuenta") String cuenta,
      @RequestParam("importe") double importe){
    ModelAndView mav = new ModelAndView("procDeposito");
    try {
      cuentaService.registrarDeposito(cuenta, importe, "0003");
      mav.addObject("mensaje", "Proceso ok.");
    } catch (Exception e) {
      mav.addObject("error", e.getMessage());
    }
    return mav;
  }
}
