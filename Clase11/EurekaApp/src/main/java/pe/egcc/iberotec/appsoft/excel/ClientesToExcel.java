package pe.egcc.iberotec.appsoft.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import pe.egcc.iberotec.appsoft.model.ClienteBean;

public class ClientesToExcel extends AbstractExcelView{

  @Override
  protected void buildExcelDocument(Map<String, Object> model, 
      HSSFWorkbook workbook, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    
    HSSFSheet excelSheet = workbook.createSheet("LISTADO DE CLIENTES");
    addHeaderSheet(workbook,excelSheet);
    
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

  private void addHeaderSheet(HSSFWorkbook workbook, HSSFSheet excelSheet) {
    HSSFRow row = excelSheet.createRow(0);
    HSSFCell celda;
    
    celda = row.createCell(0);
    celda.setCellValue("CODIGO");
    celda.setCellStyle(getEstiloTitulo(workbook));
    
    celda = row.createCell(1);
    celda.setCellValue("PATERNO");
    celda.setCellStyle(getEstiloTitulo(workbook));
    
    celda = row.createCell(2);
    celda.setCellValue("MATERNO");
    celda.setCellStyle(getEstiloTitulo(workbook));
    
    celda = row.createCell(3);
    celda.setCellValue("NOMBRE");
    celda.setCellStyle(getEstiloTitulo(workbook));
    
  }

  private CellStyle getEstiloTitulo(HSSFWorkbook libro) {
    final CellStyle cellStyle = libro.createCellStyle();
    final Font cellFont = libro.createFont();
    cellFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
    cellStyle.setFont(cellFont);
    cellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
    cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    return cellStyle;
  }
}
