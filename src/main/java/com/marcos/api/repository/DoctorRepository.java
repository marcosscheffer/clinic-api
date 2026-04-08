package com.marcos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.api.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
