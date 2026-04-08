package com.marcos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.api.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
