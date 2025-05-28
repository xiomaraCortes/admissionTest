/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.sprint3.admission_test.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicationJpaRepositoryTest {
    @Autowired
    private TestRestTemplate restTemplate;



    @Test
    public void shouldReturnMedicationsByCategoryAndExpirationDate() {
        String categoryName = "Analgesics";
        String expirationDate = "2024-08-31";

        String url = String.format("/api/medications/category/%s?expiration-after=%s", categoryName, expirationDate);

        TestRestTemplate authRestTemplate = restTemplate.withBasicAuth("admin", "admin");

        ResponseEntity<List<Medication>> response = authRestTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Medication>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Medication> medications = response.getBody();
        assertNotNull(medications);
        assertFalse(medications.isEmpty(), "Debe devolver al menos un medicamento");

        for (Medication med : medications) {
            assertEquals(categoryName, med.getCategory().getName());
            assertTrue(med.getExpirationDate().isAfter(LocalDate.parse(expirationDate)),
                    "La fecha de expiración debe ser posterior a la fecha dada");
        }
    }

   /* @Test
    public void shouldCreateMedicationAndReturn201() {

        // Construimos el medicamento para enviar en el body del POST
        Medication newMedication = Medication.builder()
                .name("Paracetamol")
                .description("Para el dolor y la fiebre")
                .price(new BigDecimal("5.50"))
                .expirationDate(LocalDate.of(2026, 12, 31))
                .category(new Category(1L, "Analgesics"))
                .build();

        TestRestTemplate authRestTemplate = restTemplate.withBasicAuth("admin", "admin");
        // Hacemos la petición POST al endpoint que crea medicamentos
        ResponseEntity<Medication> response = authRestTemplate.postForEntity(
                "/api/medications",  // URL del endpoint POST
                newMedication,
                Medication.class
        );

        // Verificamos que el status sea 201 Created
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verificamos que el cuerpo no sea null
        Medication createdMedication = response.getBody();
        assertNotNull(createdMedication);

        // Verificamos que los datos del medicamento creado coincidan con los enviados
        assertEquals("Paracetamol", createdMedication.getName());
        assertEquals("Para el dolor y la fiebre", createdMedication.getDescription());
        assertEquals(new BigDecimal("5.50"), createdMedication.getPrice());

        // Validamos que tenga ID (se haya guardado en BD)
        assertNotNull(createdMedication.getId());
    }*/

}
