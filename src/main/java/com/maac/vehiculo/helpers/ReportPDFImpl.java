package com.maac.vehiculo.helpers;

import com.maac.vehiculo.domain.Marca;
import com.maac.vehiculo.stereotypes.Report;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Report
public class ReportPDFImpl {

        public void generatePdfReport(List<Marca> lista){
            log.info("Stereotype Propio - Generate PDF Reporte {}", lista);
        }
}
