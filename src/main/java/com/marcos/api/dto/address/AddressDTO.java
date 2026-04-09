package com.marcos.api.dto.address;

import com.marcos.api.domain.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(@NotBlank String street, @NotBlank String neighborhood,
        @NotBlank @Pattern(regexp = "\\d{8}") String zipCode, @NotBlank String city,
        @NotBlank String state, Integer number, @NotBlank String complement) {
    public AddressDTO(Address address) {
        this(address.getStreet(), address.getNeighborhood(), address.getZipCode(),
                address.getCity(), address.getState(), address.getNumber(),
                address.getComplement());
    }
}
