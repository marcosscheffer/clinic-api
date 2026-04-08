package com.marcos.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcos.api.dto.PatientRequestDTO;
import com.marcos.api.service.PatientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.marcos.api.dto.PatientResponseDTO;
import com.marcos.api.dto.PatientUpdateDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping
    @Transactional
    public void newPatient(@RequestBody @Valid PatientRequestDTO dto) {
        service.newPatient(dto);
    }

    @GetMapping
    public Page<PatientResponseDTO> getPatients(
            @PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable page) {
        return service.getPatients(page);
    }

    @PutMapping
    @Transactional
    public void updatePatient(@RequestBody @Valid PatientUpdateDTO dto) {
        service.updatePatient(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
    }
}
