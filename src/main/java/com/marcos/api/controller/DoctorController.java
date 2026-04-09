package com.marcos.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.marcos.api.dto.doctor.DoctorRequestDTO;
import com.marcos.api.dto.doctor.DoctorResponseDTO;
import com.marcos.api.dto.doctor.DoctorUpdateDTO;
import com.marcos.api.dto.doctor.DoctorsResponseDTO;
import com.marcos.api.service.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DoctorResponseDTO> newDoctor(@RequestBody @Valid DoctorRequestDTO dto,
            UriComponentsBuilder uriBuilder) {
        DoctorResponseDTO response = service.newDoctor(dto);
        URI uri = uriBuilder.path("/doctors/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<DoctorsResponseDTO>> getDoctors(
            @PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable page) {

        return ResponseEntity.ok(service.getDoctors(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctor(@PathVariable long id) {
        return ResponseEntity.ok(service.getDoctor(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DoctorResponseDTO> updateDoctor(@RequestBody DoctorUpdateDTO dto) {
        DoctorResponseDTO response = service.updateDoctor(dto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DoctorsResponseDTO> deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
