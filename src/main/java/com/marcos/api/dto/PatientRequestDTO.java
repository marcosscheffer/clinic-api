package com.marcos.api.dto;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PatientRequestDTO(@NotBlank String name, @Email String email,
        @NotBlank @Pattern(regexp = "\\d{8,11}") String phone,
        @NotBlank @CPF @Pattern(regexp = "\\d{11}") String cpf, AddressDTO address) {
}
