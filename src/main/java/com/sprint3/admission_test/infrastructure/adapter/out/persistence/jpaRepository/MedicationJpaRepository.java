package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint3.admission_test.domain.model.Category;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {
    @Query(
            value = "SELECT m.* FROM medications m INNER JOIN categories c ON m.category_id = c.id WHERE c.name = ?1 AND expiration_date > ?2",
            nativeQuery = true
    )
    Iterable<Medication> findByCategoryAndDateAfter(String categoryName, LocalDate expAfter);

}
