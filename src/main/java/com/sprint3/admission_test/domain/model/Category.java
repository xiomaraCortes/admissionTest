package com.sprint3.admission_test.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "categories")
public class Category {
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
            length = 50,
            unique = true
    )
    private String name;

    @Generated
    public static CategoryBuilder builder() {
        return new CategoryBuilder();
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
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Category)) {
            return false;
        } else {
            Category other = (Category)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Category;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "Category(id=" + var10000 + ", name=" + this.getName() + ")";
    }

    @Generated
    public Category(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Generated
    public static class CategoryBuilder {
        @Generated
        private Long id;
        @Generated
        private String name;

        @Generated
        CategoryBuilder() {
        }

        @Generated
        public CategoryBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public CategoryBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @Generated
        public Category build() {
            return new Category(this.id, this.name);
        }

        @Generated
        public String toString() {
            return "Category.CategoryBuilder(id=" + this.id + ", name=" + this.name + ")";
        }
    }
}
