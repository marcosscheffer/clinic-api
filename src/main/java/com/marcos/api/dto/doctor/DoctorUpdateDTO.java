package com.marcos.api.dto.doctor;

import com.marcos.api.dto.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateDTO(@NotNull long id, String name, String phone, AddressDTO address) {
}
