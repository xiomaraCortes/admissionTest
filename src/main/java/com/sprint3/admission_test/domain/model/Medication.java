package com.sprint3.admission_test.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false,
            length = 100
    )
    private String name;
    @Column(
            name = "description",
            nullable = false
    )
    private String description;
    @Column(
            name = "price",
            nullable = false,
            precision = 12,
            scale = 2
    )
    private BigDecimal price;
    @Column(
            name = "expiration_date",
            nullable = false
    )
    private LocalDate expirationDate;
    @ManyToOne(
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Category category;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Medication that = (Medication)o;
            return Objects.equals(this.id, that.id) && Objects.equals(this.name, that.name) && Objects.equals(this.description, that.description) && Objects.equals(this.price, that.price) && Objects.equals(this.expirationDate, that.expirationDate) && Objects.equals(this.category, that.category);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.name, this.description, this.price, this.expirationDate, this.category});
    }

    @Generated
    public static MedicationBuilder builder() {
        return new MedicationBuilder();
    }

    @Generated
    public Long getId() {
        return this.id;
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
    public Category getCategory() {
        return this.category;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
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
    public void setCategory(final Category category) {
        this.category = category;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Medication(id=" + var10000 + ", name=" + this.getName() + ", description=" + this.getDescription() + ", price=" + this.getPrice() + ", expirationDate=" + this.getExpirationDate() + ", category=" + this.getCategory() + ")";
    }

    @Generated
    public Medication(final Long id, final String name, final String description, final BigDecimal price, final LocalDate expirationDate, final Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.category = category;
    }

    @Generated
    public static class MedicationBuilder {
        @Generated
        private Long id;
        @Generated
        private String name;
        @Generated
        private String description;
        @Generated
        private BigDecimal price;
        @Generated
        private LocalDate expirationDate;
        @Generated
        private Category category;

        @Generated
        MedicationBuilder() {
        }

        @Generated
        public MedicationBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public MedicationBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @Generated
        public MedicationBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @Generated
        public MedicationBuilder price(final BigDecimal price) {
            this.price = price;
            return this;
        }

        @Generated
        public MedicationBuilder expirationDate(final LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        @Generated
        public MedicationBuilder category(final Category category) {
            this.category = category;
            return this;
        }

        @Generated
        public Medication build() {
            return new Medication(this.id, this.name, this.description, this.price, this.expirationDate, this.category);
        }

        @Generated
        public String toString() {
            return "Medication.MedicationBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", price=" + this.price + ", expirationDate=" + this.expirationDate + ", category=" + this.category + ")";
        }
    }

}

