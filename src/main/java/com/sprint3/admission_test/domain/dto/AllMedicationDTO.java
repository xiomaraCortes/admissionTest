package com.sprint3.admission_test.domain.dto;

import lombok.Generated;

import java.time.LocalDate;

public class AllMedicationDTO {

    private String categoryName;
    private LocalDate ExpirationDate;

    private Long categoryId;

    @Generated
    public String getCategoryName() {
        return this.categoryName;
    }

    @Generated
    public LocalDate getExpirationDate() {
        return this.ExpirationDate;
    }


    @Generated
    public LocalDate getExpAfter() {
        return this.ExpirationDate;
    }
    @Generated
    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    @Generated
    public void setExpAfter(final LocalDate expAfter) {
        this.ExpirationDate = expAfter;
    }

    @Generated
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AllMedicationDTO)) {
            return false;
        }
        AllMedicationDTO other = (AllMedicationDTO) obj;
        if (!other.canEqual(this)) {
            return false;
        }

        Object thisCategory = this.getCategoryName();
        Object otherCategory = other.getCategoryName();
        if (thisCategory == null) {
            if (otherCategory != null) {
                return false;
            }
        } else if (!thisCategory.equals(otherCategory)) {
            return false;
        }

        Object thisExpirationDate = this.getExpirationDate();
        Object otherExpirationDate = other.getExpirationDate();
        if (thisExpirationDate == null) {
            if (otherExpirationDate != null) {
                return false;
            }
        } else if (!thisExpirationDate.equals(otherExpirationDate)) {
            return false;
        }

        return true;
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof AllMedicationDTO;
    }

    @Generated
    public int hashCode() {
        final int prime = 59;
        int result = 1;

        Object category = this.getCategoryName();
        result = result * prime + (category == null ? 43 : category.hashCode());

        Object expirationDate = this.getExpirationDate();
        result = result * prime + (expirationDate == null ? 43 : expirationDate.hashCode());

        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getCategoryName();
        return "FindAllMedicationsReqDto(categoryName=" + var10000 + ", expAfter=" + this.getExpAfter() + ")";
    }

    @Generated
    public AllMedicationDTO() {
    }

    @Generated
    public AllMedicationDTO(final String categoryName, final LocalDate expAfter) {
        this.categoryName = categoryName;
        this.ExpirationDate = expAfter;
    }



}
