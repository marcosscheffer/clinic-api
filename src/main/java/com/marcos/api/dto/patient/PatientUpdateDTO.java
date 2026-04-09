package com.marcos.api.dto.patient;

import com.marcos.api.dto.address.AddressDTO;
import jakarta.validation.constraints.NotNull;

public record PatientUpdateDTO(@NotNull long id, String name, String phone, AddressDTO address) {

}
