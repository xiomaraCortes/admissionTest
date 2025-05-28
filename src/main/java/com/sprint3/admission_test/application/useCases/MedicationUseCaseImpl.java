package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.dto.AllMedicationDTO;
import com.sprint3.admission_test.domain.dto.MedicationDTO;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    public Medication getMedicationById(Long id) {
        return (Medication)this.medicationRepository.findById(id).orElseThrow(() -> new NotFoundException("Could not find medication with ID: " + id));
    }

    public Medication create(MedicationDTO dto) {
        Optional<Category> categoryOpt = this.categoryRepository.findByName(dto.getCategoryName());
        if (categoryOpt.isEmpty()) {
            throw new NotFoundException("Category with name " + dto.getCategoryName() + " not found");
        }else {
            Medication medication = Medication.builder().name(dto.getName()).description(dto.getDescription()).price(dto.getPrice()).expirationDate(dto.getExpirationDate()).category((Category)categoryOpt.get()).build();
            return this.medicationRepository.save(medication);
        }
    }

    public List<Medication> getAllMedications(AllMedicationDTO dto) {
        Optional<Category> categoryOpt = this.categoryRepository.findByName(dto.getCategoryName());
        if (categoryOpt.isEmpty()) {
            throw new NotFoundException("Category with name " + dto.getCategoryName() + " not found");
        } else {
            return this.medicationRepository.findByCategoryAndDateAfter(dto.getCategoryName(), dto.getExpAfter());
        }
    }

    private boolean validateExpirationDate(LocalDate expirationDate) {
        LocalDate now = LocalDate.now();
        return expirationDate.isAfter(now);
    }
}
