package com.marcos.api.dto;

import jakarta.validation.constraints.NotNull;

public record PatientUpdateDTO(@NotNull long id, String name, String phone, AddressDTO address) {

}
