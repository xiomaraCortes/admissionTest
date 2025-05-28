package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.dto.AllMedicationDTO;
import com.sprint3.admission_test.domain.dto.MedicationDTO;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.CategoryJpaRepository;
import com.sprint3.admission_test.service.MedicationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.sprint3.admission_test.domain.model.Category;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/medications")
@Slf4j
public class MedicationController {

    @Generated
    private static final Logger log = LoggerFactory.getLogger(MedicationController.class);
    @Autowired
    private IMedicationUseCase medicationUseCase;
    @Autowired
    private CategoryJpaRepository categoryJpaRepository;


    @GetMapping({"/{id}"})
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.medicationUseCase.getMedicationById(id));
    }

    @PostMapping({""})
    public ResponseEntity<?> create(@RequestBody @Valid MedicationDTO dto) {
        try {
            log.info("medications.create body {}", dto);

            // Se delega la creación al UseCase, que internamente debería manejar el guardado
            Medication medication = medicationUseCase.create(dto);

            // Respuesta con el objeto creado y código 201 CREATED
            return ResponseEntity.status(HttpStatus.CREATED).body(medication);

        } catch (NotFoundException e) {
            // Si no se encuentra la categoría u otro recurso, devolver 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping({"/category/{category}"})
    public ResponseEntity<?> getAllMedicationsByCategory(@PathVariable @NotNull @Length(
            min = 3,
            max = 50
    ) String category, @RequestParam("expiration-after") String expAfter) {
        log.info("medications.medicationsByCategory category {} expAfter {}", category, expAfter);
        LocalDate expAfterDate = LocalDate.parse(expAfter);

        try {
            List<Medication> medications = this.medicationUseCase.getAllMedications(new AllMedicationDTO(category, expAfterDate));
            return new ResponseEntity(medications, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
}
