package com.marcos.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(@NotBlank String street, @NotBlank String neighborhood,
        @NotBlank @Pattern(regexp = "\\d{8}") String zipCode, @NotBlank String city,
        @NotBlank String state, Integer number, @NotBlank String complement) {

}
