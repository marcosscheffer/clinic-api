package com.marcos.api.dto.doctor;

import com.marcos.api.domain.Doctor;
import com.marcos.api.domain.Especialization;

public record DoctorsResponseDTO(long id, String name, String email, String crm,
        Especialization especialization, Boolean active) {
    public DoctorsResponseDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(),
                doctor.getEspecialization(), doctor.getActive());
    }
}
