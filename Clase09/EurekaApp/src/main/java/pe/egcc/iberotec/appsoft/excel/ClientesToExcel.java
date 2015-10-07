package pe.egcc.iberotec.appsoft.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import pe.egcc.iberotec.appsoft.model.ClienteBean;

public class ClientesToExcel extends AbstractExcelView{

  @Override
  protected void buildExcelDocument(Map<String, Object> model, 
      HSSFWorkbook workbook, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    
    HSSFSheet excelSheet = workbook.createSheet("LISTADO DE CLIENTES");
    addHeaderSheet(excelSheet);
    
    List<ClienteBean> listaClientes;
    listaClientes = (List<ClienteBean>) model.get("listaClientes");
    addDataSheet(excelSheet,listaClientes);
    
  }

  private void addDataSheet(HSSFSheet excelSheet, 
      List<ClienteBean> listaClientes) {
    int fila = 0;
    for(ClienteBean bean: listaClientes){
      fila++;
      HSSFRow row = excelSheet.createRow(fila);
      row.createCell(0).setCellValue(bean.getCodigo());
      row.createCell(1).setCellValue(bean.getPaterno());
      row.createCell(2).setCellValue(bean.getMaterno());
      row.createCell(3).setCellValue(bean.getNombre());
    }
  }

  private void addHeaderSheet(HSSFSheet excelSheet) {
    HSSFRow row = excelSheet.createRow(0);
    row.createCell(0).setCellValue("CODIGO");
    row.createCell(1).setCellValue("PATERNO");
    row.createCell(2).setCellValue("MATERNO");
    row.createCell(3).setCellValue("NOMBRE");
  }

}
