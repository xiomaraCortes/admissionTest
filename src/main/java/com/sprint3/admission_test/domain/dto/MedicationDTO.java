package com.sprint3.admission_test.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Generated;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class MedicationDTO {

    private @NotNull @Length(
            min = 5,
            max = 100
    ) String name;
    private @NotNull @Length(
            min = 30,
            max = 255
    ) String description;
    private @NotNull @DecimalMin(
            value = "0.0",
            inclusive = false
    ) @Digits(
            integer = 12,
            fraction = 2
    ) BigDecimal price;
    private LocalDate expirationDate;
    private @NotNull @Length(
            min = 3,
            max = 50
    ) String categoryName;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            MedicationDTO that = (MedicationDTO)o;
            return Objects.equals(this.name, that.name) && Objects.equals(this.description, that.description) && Objects.equals(this.price, that.price) && Objects.equals(this.expirationDate, that.expirationDate) && Objects.equals(this.categoryName, that.categoryName);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.description, this.price, this.expirationDate, this.categoryName});
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public BigDecimal getPrice() {
        return this.price;
    }

    @Generated
    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    @Generated
    public String getCategoryName() {
        return this.categoryName;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @Generated
    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    @Generated
    public void setExpirationDate(final LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Generated
    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    @Generated
    public String toString() {
        String var10000 = this.getName();
        return "CreateMedicationReqDto(name=" + var10000 + ", description=" + this.getDescription() + ", price=" + this.getPrice() + ", expirationDate=" + this.getExpirationDate() + ", categoryName=" + this.getCategoryName() + ")";
    }

    @Generated
    public MedicationDTO(final String name, final String description, final BigDecimal price, final LocalDate expirationDate, final String categoryName) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.categoryName = categoryName;
    }

    @Generated
    public MedicationDTO() {
    }
}
