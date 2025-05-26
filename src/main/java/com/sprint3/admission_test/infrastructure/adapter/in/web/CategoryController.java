package com.sprint3.admission_test.infrastructure.adapter.in.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.CategoryJpaRepository;
import com.sprint3.admission_test.service.MedicationService;

@RestController
@Slf4j
public class CategoryController {
 @Autowired
    private CategoryJpaRepository categoryJpaRepository; // Inyectar el repositorio

    // Endpoint para obtener una categoría por su ID
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryJpaRepository.findById(id);
        
        // Si la categoría no se encuentra, devolver un error 404
        if (category.isEmpty()) {
            log.info(" ENTRA A [CategoryController][CategoryJpaRepository] La categoria esta vacia" +category);
            return ResponseEntity.notFound().build();
        }

        // Devolver la categoría encontrada con un estado 200 OK
        return ResponseEntity.ok(category.get());
    }
}
