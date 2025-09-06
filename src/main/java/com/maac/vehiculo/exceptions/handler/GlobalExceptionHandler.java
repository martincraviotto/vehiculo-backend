package com.maac.vehiculo.exceptions.handler;

import com.maac.vehiculo.exceptions.MarcaNotFoundException;
import com.maac.vehiculo.exceptions.ModeloNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ModeloNotFoundException.class)
    ProblemDetail handleBookmarkNotFoundException(ModeloNotFoundException e){

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Modelo No Encontrado");
        //la siguiente URI  debería redirigirnos a un lugar donde se especifique que significa que no está el Modelo
        problemDetail.setType(URI.create("http://localhost:8080/escuelait/api/v1/endpoints/not-found"));
        problemDetail.setProperty("errorCategory","Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }


    //Podría manejar más de una exception añadiendo dentro de los corchetes
    @ExceptionHandler({MarcaNotFoundException.class})
    ProblemDetail handleBookmarkNotFoundException(MarcaNotFoundException e){

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Marca No Encontrada");
        //la siguiente URI  debería redirigirnos a un lugar donde se especifique que significa que no está la Marca
        problemDetail.setType(URI.create("http://localhost:8080/escuelait/api/v1/endpoints/not-found"));
        problemDetail.setProperty("errorCategory","Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }


}
