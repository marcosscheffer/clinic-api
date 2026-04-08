package com.marcos.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.marcos.api.dto.PatientRequestDTO;
import com.marcos.api.repository.PatientRepository;
import com.marcos.api.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.marcos.api.dto.PatientResponseDTO;
import com.marcos.api.dto.PatientUpdateDTO;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public void newPatient(PatientRequestDTO dto) {
        repository.save(new Patient(dto));
    }

    public Page<PatientResponseDTO> getPatients(Pageable page) {
        return repository.findAll(page).map(PatientResponseDTO::new);
    }

    public void updatePatient(PatientUpdateDTO dto) {
        Optional<Patient> patient = repository.findById(dto.id());
        if (patient.isEmpty()) {
            return;
        }
        patient.get().update(dto);
        repository.save(patient.get());
    }

    public void deletePatient(Long id) {
        Optional<Patient> patient = repository.findById(id);
        if (patient.isEmpty()) {
            return;
        }
        patient.get().delete();
        repository.save(patient.get());
    }

}
