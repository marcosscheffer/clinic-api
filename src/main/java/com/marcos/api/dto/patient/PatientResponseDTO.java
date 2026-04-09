package com.marcos.api.dto.patient;

import com.marcos.api.dto.address.AddressDTO;
import com.marcos.api.domain.Patient;

public record PatientResponseDTO(long id, String name, String email, String cpf, Boolean active,
        AddressDTO address) {

    public PatientResponseDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(),
                patient.getActive(), new AddressDTO(patient.getAddress()));
    }
}
