package com.marcos.api.dto.doctor;

import com.marcos.api.domain.Especialization;
import com.marcos.api.dto.address.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRequestDTO(@NotBlank String name, @NotBlank @Email String email, String phone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Especialization especialization, @NotNull @Valid AddressDTO address) {

}
