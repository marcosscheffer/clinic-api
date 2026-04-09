package com.marcos.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import com.marcos.api.service.PatientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.marcos.api.dto.patient.PatientRequestDTO;
import com.marcos.api.dto.patient.PatientUpdateDTO;
import com.marcos.api.dto.patient.PatientsResponseDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.marcos.api.dto.patient.PatientResponseDTO;



@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientResponseDTO> newPatient(@RequestBody @Valid PatientRequestDTO dto,
            UriComponentsBuilder uriBuilder) {
        PatientResponseDTO response = service.newPatient(dto);
        URI uri = uriBuilder.path("/patients/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<PatientsResponseDTO>> getPatients(
            @PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable page) {
        return ResponseEntity.ok(service.getPatients(page));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PatientResponseDTO> updatePatient(
            @RequestBody @Valid PatientUpdateDTO dto) {
        PatientResponseDTO response = service.updatePatient(dto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PatientResponseDTO> deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getMethodName(@PathVariable long id) {
        return ResponseEntity.ok(service.getPatient(id));
    }
}
