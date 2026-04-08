package com.marcos.api.dto;

import com.marcos.api.model.Especialization;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRequestDTO(@NotBlank String name, @NotBlank @Email String email, String phone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Especialization especialization, @NotNull @Valid AddressDTO address) {

}
