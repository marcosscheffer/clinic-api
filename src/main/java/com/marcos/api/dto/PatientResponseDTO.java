package com.marcos.api.dto;

import com.marcos.api.model.Patient;

public record PatientResponseDTO(long id, String name, String email, String cpf, Boolean active) {
    public PatientResponseDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(),
                patient.getActive());
    }
}
