package com.marcos.api.dto;

import jakarta.validation.constraints.NotNull;

public record DoctorUpdateDTO(@NotNull long id, String name, String phone, AddressDTO address) {
}
