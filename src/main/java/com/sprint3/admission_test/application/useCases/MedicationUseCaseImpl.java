package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Medication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;

    @Override
    public Medication getMedicationById(Long id) {
        log.info(" ENTRA A [MedicationUseCaseImpl][getMedicationById]]" + id);
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    public Medication addMedication(Medication medication) {
        log.info(" ENTRA A [MedicationUseCaseImpl][addMedication]]" +medication);
        return medicationRepository.save(medication); // Llama al repositorio para guardar el medicamento
    }
}
