package com.marcos.api.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.api.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
