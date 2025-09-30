package com.maac.vehiculo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.maac.vehiculo.validators.Cuit;
import com.maac.vehiculo.validators.groups.OnCreate;
import com.maac.vehiculo.validators.groups.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

@JsonPropertyOrder({"webSite", "marca", "id"})
@Schema(description = "Schema que define la  Marca de Vehiculo")
@Data
public class Marca {

    //@NonNull
    @Schema(description = "Identificador de una marca", example = "1")
    private Long id;

    //@NonNull //Lombok, y es para hacer mandatorio el atributo en el constructor.
    @NotNull(groups = OnCreate.class) //Java Validation - Valor sí o sí.
    @Schema(description = "Nombre de una marca", example = "Jeep")
    private String marca;

    @Schema(description = "Descripcion de una marca", example = "Fabricante estadounidense de autos deportivos")
    private String descripcion;



    /*
    @JsonProperty("SitioWeb")
    @NotBlank(groups = OnUpdate.class) //Java Validation
    @Size(min = 6, max = 20) //Java Validation
    @Schema(description = "Sitio Web del fabricante de la marca", example = "www.jeep.com")
    private String webSite;

    //@JsonIgnore
    @AssertTrue(groups = {OnUpdate.class, OnCreate.class})
    @Schema(description = "Indica si la marca es Argentina", example = "True")
    private boolean industriaArgentina;


     */
    /*
    @Email
    private String mail;


    @PositiveOrZero
    @Positive
    private int puntuacion;

    @NegativeOrZero
    @Negative
    private int ranking;

    //@PastOrPresent
    @Past
    private LocalDate fechaInicio;

    @FutureOrPresent
    //@Future
    private LocalDate auditoria;



    @Cuit(groups = {OnUpdate.class, OnCreate.class})
    private String cuit;
    */
}
