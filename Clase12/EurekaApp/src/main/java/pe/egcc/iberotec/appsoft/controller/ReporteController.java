package pe.egcc.iberotec.appsoft.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.egcc.iberotec.appsoft.model.ClienteBean;
import pe.egcc.iberotec.appsoft.service.ClienteService;
import pe.egcc.iberotec.appsoft.service.ConsultaService;

@Controller
public class ReporteController {

  @Autowired
  private ConsultaService consultaService;

  @RequestMapping(value = "repoClientes.htm", method = RequestMethod.GET)
  public void repoClientes(HttpServletResponse response) {
    try {
      // Datos
      ClienteBean clienteBean = new ClienteBean();
      clienteBean.setVacios();
      List<ClienteBean> lista;
      lista = consultaService.obtenerClientes(clienteBean);
      JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lista);
      // Parámetros
      Map<String, Object> pars = new HashMap<String, Object>();
      String logoFile = "/pe/egcc/iberotec/appsoft/img/logo.gif";
      InputStream logoStrean = getClass().getResourceAsStream(logoFile);
      pars.put("LOGO", logoStrean);
      // Creando el reporte
      String repoFile = "/pe/egcc/iberotec/appsoft/reports/repoClientes.jasper";
      InputStream repoStream = getClass().getResourceAsStream(repoFile);
      JasperReport jasperReport = (JasperReport) JRLoader.loadObject(repoStream);
      byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, pars, data);
      // Enviando el reporte al browser
      response.setContentType("application/pdf");
      response.setContentLength(bytes.length);
      ServletOutputStream out = response.getOutputStream();
      out.write(bytes, 0, bytes.length);
      out.flush();
      out.close();
    } catch (Exception e) {
    }
  }
}
