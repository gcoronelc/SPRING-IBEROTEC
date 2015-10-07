package pe.egcc.iberotec.appsoft.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

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
  
  // Retorna HTML
  @RequestMapping(value="verClientes.htm", method=RequestMethod.POST)
  public ModelAndView verClientes(
      @ModelAttribute ClienteBean clienteBean
      ){
    ModelAndView mav = new ModelAndView("conClientes2");
    mav.addObject("lista", consultaService.obtenerClientes(clienteBean));
    return mav;
  }
  
  // Retorna JSON con GSon
  @RequestMapping(value="verClientes2.htm", method=RequestMethod.POST,
      produces="application/text")
  @ResponseBody
  public String verClientes2(@ModelAttribute ClienteBean clienteBean){
    
    List<ClienteBean> lista;
    lista = consultaService.obtenerClientes(clienteBean);
    
    Gson gson = new Gson();
    String data = gson.toJson(lista);
    
    return data;
    
  }
  
  
 //Retorna JSON con Jackson
 @RequestMapping(value="verClientes3.htm", method=RequestMethod.POST,
     produces="application/json")
 @ResponseBody
 public List<ClienteBean> 
 verClientes3(@ModelAttribute ClienteBean clienteBean){
   
   List<ClienteBean> lista;
   lista = consultaService.obtenerClientes(clienteBean);
   
   return lista;
   
 }  
  
 @RequestMapping(value="clientesToExcel", 
     produces="application/vnd.ms-excel" )
 @ResponseBody
 public String clientesToExcel(@ModelAttribute ClienteBean clienteBean,
     HttpServletResponse response){
   
   response.setHeader("Content-disposition", "attachment; filename=clientes.xls");
   
   String data = "CODIGO\tPATERNO\tMATERNO\tNOMBRE";
   
   List<ClienteBean> lista;
   lista = consultaService.obtenerClientes(clienteBean);
   
   for(ClienteBean bean: lista){
     String fila = bean.getCodigo() + 
         "\t" + bean.getPaterno() +
         "\t" + bean.getMaterno() + 
         "\t" + bean.getNombre();
     data += "\n" + fila;
   }
   
   return data;
 }
  
 
 @RequestMapping(value = "/clientesToExcel2", method = RequestMethod.GET)
 public ModelAndView clientesToExcel2(@ModelAttribute ClienteBean clienteBean,
    HttpServletResponse response ) {
   
   response.setHeader("Content-disposition", 
       "attachment; filename=listaClientes.xls");
   
   List<ClienteBean> listaClientes;
   listaClientes = consultaService.obtenerClientes(clienteBean); 
   return new ModelAndView("clientesToExcel", "listaClientes", listaClientes);
   
 }
  
}
