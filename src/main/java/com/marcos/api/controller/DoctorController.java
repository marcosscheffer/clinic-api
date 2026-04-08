package com.marcos.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcos.api.dto.DoctorRequestDTO;
import com.marcos.api.dto.DoctorResponseDTO;
import com.marcos.api.dto.DoctorUpdateDTO;
import com.marcos.api.service.DoctorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @PostMapping
    @Transactional
    public void newDoctor(@RequestBody @Valid DoctorRequestDTO dto) {
        service.newDoctor(dto);
    }

    @GetMapping
    public Page<DoctorResponseDTO> getDoctors(
            @PageableDefault(size = 10, page = 0, sort = {"name"}) Pageable page) {

        return service.getDoctors(page);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody DoctorUpdateDTO dto) {
        service.updateDoctor(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
    }
}
