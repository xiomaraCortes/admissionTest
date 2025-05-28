package com.sprint3.admission_test.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.CategoryJpaRepository;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.MedicationJpaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MedicationService {

    /*@Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Autowired
    private MedicationJpaRepository medicationJpaRepository; 

     // Método para agregar un nuevo medicamento
    public Medication addMedication(Medication newMedication) {
        // Verifica si la categoría proporcionada existe en la base de datos
        if (newMedication.getCategory() == null || newMedication.getCategory().getId() == null) {
            log.info(" ENTRA A [MedicationService][addMedication]]");
            throw new IllegalArgumentException("Category must be provided and valid.");
        }

        // Buscar la categoría en la base de datos
        Category existingCategory = categoryJpaRepository.findById(newMedication.getCategory().getId())
            .orElseThrow(() -> new IllegalArgumentException("Category with id " + newMedication.getCategory().getId() + " not found"));

        // Establecer la categoría validada al medicamento
        newMedication.setCategory(existingCategory);

        // Guardar el medicamento
        return medicationJpaRepository.save(newMedication);
    }

     // Método para consultar medicamentos por categoría y fecha de expiración
    public List<Medication> getMedicationsByCategoryAndExpirationDateAfter(Category category, LocalDate expirationDate) {
        log.info(" ENTRA A [MedicationService][getMedicationsByCategoryAndExpirationDateAfter]]" + category );
        return medicationJpaRepository.findByCategoryAndDateAfter(category, expirationDate);
    }
*/



}
