package com.marcos.api.dto.patient;

import com.marcos.api.domain.Patient;

public record PatientsResponseDTO(long id, String name, String email, String cpf, Boolean active) {
    public PatientsResponseDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(),
                patient.getActive());
    }
}
