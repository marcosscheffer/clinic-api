package com.marcos.api.dto.doctor;

import com.marcos.api.domain.Doctor;
import com.marcos.api.domain.Especialization;
import com.marcos.api.dto.address.AddressDTO;

public record DoctorResponseDTO(long id, String name, String email, String phone, String crm,
        Especialization especialization, AddressDTO address, Boolean active) {

    public DoctorResponseDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(),
                doctor.getCrm(), doctor.getEspecialization(), new AddressDTO(doctor.getAddress()),
                doctor.getActive());
    }
}
