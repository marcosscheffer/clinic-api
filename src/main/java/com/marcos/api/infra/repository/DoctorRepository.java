package com.marcos.api.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.api.domain.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
