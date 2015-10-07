package pe.egcc.iberotec.appsoft.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.iberotec.appsoft.model.EmpleadoBean;
import pe.egcc.iberotec.appsoft.service.CuentaService;

@Controller
public class CuentaController {

  @Autowired
  private CuentaService cuentaService;
  
  @RequestMapping(value="procDeposito.htm", method=RequestMethod.POST,
      produces="application/json")
  @ResponseBody
  public Map<String,Object> procDeposito(
      @RequestParam("cuenta") String cuenta,
      @RequestParam("importe") double importe,
      HttpSession session){
    Map<String,Object> rpta = new HashMap<String, Object>();
    try {
      // Datos del empleado
      LogonController logonController;
      logonController = (LogonController) session.getAttribute("logonController");
      EmpleadoBean empleadoBean = logonController.getEmpleadoBean();
      cuentaService.registrarDeposito(cuenta, importe, empleadoBean.getCodigo());
      rpta.put("code", 1);
      rpta.put("mensaje", "Proceso ok.");
    } catch (Exception e) {
      rpta.put("code", -1);
      rpta.put("mensaje", e.getMessage());
    }
    return rpta;
  }
}
