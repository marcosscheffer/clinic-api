package com.marcos.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marcos.api.repository.DoctorRepository;
import com.marcos.api.dto.DoctorRequestDTO;
import com.marcos.api.dto.DoctorResponseDTO;
import com.marcos.api.dto.DoctorUpdateDTO;
import com.marcos.api.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository repository;

    public Page<DoctorResponseDTO> getDoctors(Pageable page) {
        return repository.findAll(page).map(DoctorResponseDTO::new);
    }

    public void newDoctor(DoctorRequestDTO dto) {
        repository.save(new Doctor(dto));
    }

    public void updateDoctor(DoctorUpdateDTO dto) {
        Optional<Doctor> doctor = repository.findById(dto.id());
        if (doctor.isEmpty()) {
            return;
        }
        doctor.get().update(dto);
        repository.save(doctor.get());
    }

    public void deleteDoctor(Long id) {
        Optional<Doctor> doctor = repository.findById(id);
        if (doctor.isEmpty()) {
            return;
        }
        doctor.get().delete();
        repository.save(doctor.get());
    }

}
