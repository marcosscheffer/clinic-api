package com.marcos.api.domain;

import com.marcos.api.dto.address.AddressDTO;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private Integer number;
    private String complement;


    public Address() {}

    public Address(AddressDTO dto) {
        this.street = dto.street();
        this.neighborhood = dto.neighborhood();
        this.zipCode = dto.zipCode();
        this.city = dto.city();
        this.state = dto.state();
        this.number = dto.number();
        this.complement = dto.complement();
    }

    public void update(AddressDTO address) {
        if (address.street() != null) {
            this.street = address.street();
        }
        if (address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if (address.zipCode() != null) {
            this.zipCode = address.zipCode();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.state() != null) {
            this.state = address.state();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }
    }
}
