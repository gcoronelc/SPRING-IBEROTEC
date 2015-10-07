package pe.egcc.iberotec.appsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.iberotec.appsoft.model.EmpleadoBean;
import pe.egcc.iberotec.appsoft.service.EmpleadoService;

@Controller
@Scope(value="session")
public class LogonController {
  
  @Autowired
  private EmpleadoService empleadoService;
  
  private EmpleadoBean empleadoBean;
  
  public EmpleadoBean getEmpleadoBean() {
    return empleadoBean;
  }

  @RequestMapping(value="logonIngresar.htm", method=RequestMethod.POST)
  public ModelAndView logonIngresar(
      @RequestParam("usuario") String usuario,
      @RequestParam("clave") String clave){
    ModelAndView mav;
    try {
      empleadoBean = empleadoService.validar(usuario, clave);
      if(empleadoBean == null){
        throw new RuntimeException("Datos no son correctos.");
      }
      mav = new ModelAndView("main");
      mav.addObject("usuario", empleadoBean);
    } catch (Exception e) {
      mav = new ModelAndView("home");
      mav.addObject("error", e.getMessage());
    }
    return mav;
  }
  
  @RequestMapping(value="logonIngresar.htm", method=RequestMethod.GET)
  public String logonIngresar(){
    return "home";
  }
  
}
