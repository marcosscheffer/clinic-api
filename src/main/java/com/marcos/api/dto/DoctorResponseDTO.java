package com.marcos.api.dto;

import com.marcos.api.model.Especialization;
import com.marcos.api.model.Doctor;

public record DoctorResponseDTO(long id, String name, String email, String crm,
        Especialization especialization, Boolean active) {
    public DoctorResponseDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(),
                doctor.getEspecialization(), doctor.getActive());
    }
}
