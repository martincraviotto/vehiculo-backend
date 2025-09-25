package com.maac.vehiculo.services;

import com.maac.vehiculo.domain.Marca;
import com.maac.vehiculo.helpers.ReportPDFImpl;
import com.maac.vehiculo.mappers.MarcasMapper;
import com.maac.vehiculo.persistence.entities.MarcaEntity;
import com.maac.vehiculo.persistence.repositories.MarcaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j //Sirve para disponer de un logger.
@Lazy // Retrasa la instalación hasta que sea necesaria.
// es es para definir que implementación utilizar en base a la configuracion en el archivo de propiedades
@ConditionalOnProperty(prefix = "implementacion", value = "marcas", havingValue = "autos")
@Service("autos")
public class MarcasServiceImpl implements  MarcasService{

    //@Autowired
    private ReportPDFImpl reportPDF;

    private MarcaRepository marcaRepository;
    private MarcasMapper marcasMapper;

    public MarcasServiceImpl(ReportPDFImpl reportPDF, MarcaRepository marcaRepository, MarcasMapper marcasMapper) {
        log.info("Ejecutando constructor MarcasServiceImpl - autos");
        this.reportPDF = reportPDF;
        this.marcaRepository = marcaRepository;
        this.marcasMapper = marcasMapper;
    }

    public List<Marca> listAllMarcas(){
        //this.reportPDF.generatePdfReport(marcas);
        log.info("Ejecutando listAllMarcas");
        return marcaRepository.findAll()
                .stream()
                .map(marcasMapper::mapToMarca)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Marca> getMarcaById(Long id) {
        log.info("Ejecutando getMarcaById - autos");
        return marcaRepository.findById(id)
                .map(marcasMapper::mapToMarca);
    }

    @Override
    public Optional<Marca> addMarca(Marca marca) {
        MarcaEntity saved = marcaRepository.save(marcasMapper.mapToMarcaEntity(marca));
        log.info("Ejecutando addMarca - autos - {}", saved);
        return Optional.of(marcasMapper.mapToMarca(saved));
    }

    @Override
    public Optional<List<Marca>> addMarcas(List<Marca> marcas) {
        List<MarcaEntity> marcaEntityList = marcas.stream()
                .map(marcasMapper::mapToMarcaEntity)
                .collect(Collectors.toList());
        List<MarcaEntity> marcaEntityListSaved = marcaRepository.saveAll(marcaEntityList);
        log.info("Ejecutando addMarcas -seeds - autos");
        return Optional.of(marcaEntityListSaved.stream().map(marcasMapper::mapToMarca).collect(Collectors.toList()));
    }


}
