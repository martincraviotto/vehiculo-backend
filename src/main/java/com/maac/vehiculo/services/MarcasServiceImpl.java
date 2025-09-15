package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Marca;
import com.maac.vehiculo.helpers.ReportPDFImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j //Sirve para disponer de un logger.
@Lazy // Retrasa la instalación hasta que sea necesaria.
// es es para definir que implementación utilizar en base a la configuracion en el archivo de propiedades
@ConditionalOnProperty(prefix = "implementacion", value = "marcas", havingValue = "autos")
@Service("autos")
public class MarcasServiceImpl implements  MarcasService{


    ArrayList<Marca> marcas = new ArrayList<>(
            List.of(new Marca(1L,"Citroen"),
                    new Marca(2L,"Ford"),
                    new Marca(3L,"Ram"))
    );

    //@Autowired
    private ReportPDFImpl reportPDF;

    public MarcasServiceImpl(ReportPDFImpl reportPDF) {
        this.reportPDF = reportPDF;
        log.info("Ejecutando constructor MarcasServiceImpl - autos");
    }

    public List<Marca> listAllMarcas(){
        this.reportPDF.generatePdfReport(marcas);
        return marcas;
    }
}
