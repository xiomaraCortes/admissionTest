package com.sprint3.admission_test.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicationDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
    private String name;


    @NotBlank (message = "La descripcion es obligatorio")
    @Size(min = 30, max = 255, message = "La descripcion  debe tener entre 30 y 255 caracteres")
    private String description;



    @NotNull(message = "El precio es obligatorio")
    @Digits(integer = 10, fraction = 2, message = "El precio debe tener como máximo 10 dígitos enteros y 2 decimales")
    @DecimalMin(value = "0.01", inclusive = true, message = "El precio debe ser mayor a 0")
    private BigDecimal price;


    @NotNull(message = "La fecha de expiración es obligatoria")
    @Future(message = "La fecha debe estar en el futuro")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;



    @NotBlank (message = "La Categoria es obligatoria")
    @Size( max = 50, message = "La descripcion  debe tener entre 30 y 255 caracteres")
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
