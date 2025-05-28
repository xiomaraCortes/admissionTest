package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.dto.AllMedicationDTO;
import com.sprint3.admission_test.domain.dto.MedicationDTO;
import com.sprint3.admission_test.domain.model.Medication;

import java.util.List;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);

    Medication create(MedicationDTO req);

    List<Medication> getAllMedications(AllMedicationDTO req);
}
