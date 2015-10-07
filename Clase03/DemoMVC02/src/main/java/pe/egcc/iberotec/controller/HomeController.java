package pe.egcc.iberotec.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.iberotec.dto.PagoDto;
import pe.egcc.iberotec.service.PagoService;

@Controller
public class HomeController {

  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @Autowired
  private PagoService pagoService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);

    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    model.addAttribute("serverTime", formattedDate);

    return "home";
  }

  @RequestMapping(value = "pagoForm.htm", method = RequestMethod.GET)
  public String pagoForm() {
    return "pagoForm";
  }

  @RequestMapping(value = "pagoProcess.htm", method = RequestMethod.POST)
  public ModelAndView pagoProcess(HttpServletRequest request) {
    // Datos
    PagoDto pagoDto = new PagoDto();
    pagoDto.setHorasDia(Integer.parseInt(request.getParameter("horasDia")));
    pagoDto.setDias(Integer.parseInt(request.getParameter("dias")));
    pagoDto.setPagoHora(Double.parseDouble(request.getParameter("pagoHora")));
    // Proceso
    pagoService.procesar(pagoDto);
    // Reporte
    ModelAndView mav = new ModelAndView("pagoForm");
    mav.addObject("pagoDto", pagoDto);
    return mav;
  }

  @RequestMapping(value = "pagoForm2.htm", method = RequestMethod.GET)
  public String pagoForm2() {
    return "pagoForm2";
  }

  @RequestMapping(value = "pagoProcess2.htm", method = RequestMethod.POST)
  public ModelAndView pagoProcess(@RequestParam("horasDia") int horasDia, @RequestParam("dias") int dias,
      @RequestParam("pagoHora") double pagoHora) {
    // Datos
    PagoDto pagoDto = new PagoDto();
    pagoDto.setHorasDia(horasDia);
    pagoDto.setDias(dias);
    pagoDto.setPagoHora(pagoHora);
    // Proceso
    pagoService.procesar(pagoDto);
    // Reporte
    ModelAndView mav = new ModelAndView("pagoForm2");
    mav.addObject("pagoDto", pagoDto);
    return mav;
  }

  @RequestMapping(value = "pagoForm3.htm", method = RequestMethod.GET)
  public String pagoForm3() {
    return "pagoForm3";
  }

  @RequestMapping(value = "pagoProcess3.htm", method = RequestMethod.POST)
  public ModelAndView pagoProcess(
      @ModelAttribute PagoDto pagoDto,
      @RequestParam("nombre") String nombre) {
    // Proceso
    System.out.println("Hola " + nombre);
    pagoService.procesar(pagoDto);
    // Reporte
    ModelAndView mav = new ModelAndView("pagoForm3");
    mav.addObject("pagoDto", pagoDto);
    return mav;
  }
}
