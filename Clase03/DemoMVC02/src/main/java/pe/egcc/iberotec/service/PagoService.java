package pe.egcc.iberotec.service;

import org.springframework.stereotype.Service;

import pe.egcc.iberotec.dto.PagoDto;

@Service
public class PagoService {

  public void procesar(PagoDto pagoDto){
    // Variables
    double ingresos, renta, neto;
    // Proceso
    ingresos = pagoDto.getHorasDia() * pagoDto.getDias() * pagoDto.getPagoHora();
    if(ingresos > 1500.0){
      renta = ingresos * 0.10;
    } else {
      renta = 0.0;
    }
    neto = ingresos - renta;
    // Reporte
    pagoDto.setIngresos(ingresos);
    pagoDto.setRenta(renta);
    pagoDto.setNeto(neto);
  }
  
}
