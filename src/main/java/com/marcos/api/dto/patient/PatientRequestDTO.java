package com.marcos.api.dto.patient;

import org.hibernate.validator.constraints.br.CPF;
import com.marcos.api.dto.address.AddressDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PatientRequestDTO(@NotBlank String name, @Email String email,
                @NotBlank @Pattern(regexp = "\\d{8,11}") String phone,
                @NotBlank @CPF @Pattern(regexp = "\\d{11}") String cpf, AddressDTO address) {
}
