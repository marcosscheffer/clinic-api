package com.marcos.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.marcos.api.domain.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.marcos.api.dto.patient.PatientRequestDTO;
import com.marcos.api.dto.patient.PatientUpdateDTO;
import com.marcos.api.dto.patient.PatientsResponseDTO;
import com.marcos.api.infra.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import com.marcos.api.dto.patient.PatientResponseDTO;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public PatientResponseDTO newPatient(PatientRequestDTO dto) {
        Patient patient = new Patient(dto);
        repository.save(new Patient(dto));
        return new PatientResponseDTO(patient);
    }

    public Page<PatientsResponseDTO> getPatients(Pageable page) {
        return repository.findAll(page).map(PatientsResponseDTO::new);
    }

    public PatientResponseDTO updatePatient(PatientUpdateDTO dto) {
        Optional<Patient> patient = repository.findById(dto.id());
        if (patient.isEmpty()) {
            throw new EntityNotFoundException("Patient not found");
        }
        patient.get().update(dto);
        repository.save(patient.get());
        return new PatientResponseDTO(patient.get());
    }

    public void deletePatient(Long id) {
        Optional<Patient> patient = repository.findById(id);
        if (patient.isEmpty()) {
            throw new EntityNotFoundException("Patient not found");
        }
        patient.get().delete();
        repository.save(patient.get());
    }

    public PatientResponseDTO getPatient(long id) {
        Optional<Patient> patient = repository.findById(id);
        if (patient.isEmpty()) {
            throw new EntityNotFoundException("Patient not found");
        }
        return new PatientResponseDTO(patient.get());
    }

}
