package com.marcos.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import com.marcos.api.domain.Doctor;
import com.marcos.api.dto.doctor.DoctorRequestDTO;
import com.marcos.api.dto.doctor.DoctorResponseDTO;
import com.marcos.api.dto.doctor.DoctorUpdateDTO;
import com.marcos.api.dto.doctor.DoctorsResponseDTO;
import com.marcos.api.infra.repository.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository repository;

    public Page<DoctorsResponseDTO> getDoctors(Pageable page) {
        return repository.findAll(page).map(DoctorsResponseDTO::new);
    }

    public DoctorResponseDTO newDoctor(DoctorRequestDTO dto) {
        Doctor doctor = new Doctor(dto);
        repository.save(doctor);
        return new DoctorResponseDTO(doctor);
    }

    public DoctorResponseDTO updateDoctor(DoctorUpdateDTO dto) {
        Optional<Doctor> doctor = repository.findById(dto.id());
        if (doctor.isEmpty()) {
            throw new RuntimeException("Doctor not found");
        }
        doctor.get().update(dto);
        repository.save(doctor.get());
        return new DoctorResponseDTO(doctor.get());
    }

    public DoctorResponseDTO getDoctor(Long id) {
        Optional<Doctor> doctor = repository.findById(id);
        if (doctor.isEmpty()) {
            throw new EntityNotFoundException("Doctor not found");
        }
        return new DoctorResponseDTO(doctor.get());
    }

    public void deleteDoctor(Long id) {
        Optional<Doctor> doctor = repository.findById(id);
        if (doctor.isEmpty()) {
            throw new EntityNotFoundException("Doctor not found");
        }
        doctor.get().delete();
        repository.save(doctor.get());
    }

}
