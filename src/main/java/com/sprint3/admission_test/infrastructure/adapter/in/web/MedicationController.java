package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.dto.MedicationDTO;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.service.MedicationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.sprint3.admission_test.domain.model.Category;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/medications")
@Slf4j
public class MedicationController {

    @Autowired  
    private IMedicationUseCase medicationUseCase;
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate expirationDate;
    private Category category;

    @Autowired
    private MedicationService medicationService;  // Servicio inyectado

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        log.info("getMedicationById with id: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }
   
//    @PostMapping("/addmedications")
//    public ResponseEntity<Medication> addMedication(@RequestBody Medication newMedication) {
//        Medication savedMedication = medicationService.addMedication(newMedication);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedication);
//    }

    @PostMapping("/addmedications")
    public ResponseEntity<Medication> addMedication(@Valid @RequestBody MedicationDTO dto) {
        log.info(" ENTRA A [MedicationController][addmedications]]");
        Medication medication = new Medication();
        medication.setName(dto.getName());
        medication.setDescription(dto.getDescription());
        medication.setPrice(dto.getPrice());
        medication.setExpirationDate(dto.getExpirationDate());
        Medication savedMedication = medicationService.addMedication(medication);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedication);

    }

    // Endpoint para obtener medicamentos de una categoría que caducarán después de una fecha dada
    @GetMapping("filter")
    public ResponseEntity<List<Medication>> getMedicationsByCategoryAndExpirationDateAfter(
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("expirationDate") String expirationDate) {
        log.info(" ENTRA A [MedicationController][filter]]");
        // Convertir la fecha recibida en el formato adecuado (LocalDate)
        LocalDate date = LocalDate.parse(expirationDate);

        // Crear una categoría a partir del ID proporcionado
        Category category = new Category();
        category.setId(categoryId);

        // Obtener los medicamentos que cumplen con el criterio
        List<Medication> medications = medicationService.getMedicationsByCategoryAndExpirationDateAfter(category, date);

        // Si no hay medicamentos, devolver No Content (204)
        if (medications.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Devolver la lista de medicamentos con un código 200 OK
        return ResponseEntity.ok(medications);
    }



    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


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


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }
    
}
