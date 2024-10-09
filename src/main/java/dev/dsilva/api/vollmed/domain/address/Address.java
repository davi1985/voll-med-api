package dev.dsilva.api.vollmed.domain.address;

import dev.dsilva.api.vollmed.dtos.CreateAddress;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String publicArea;
    private String neighborhood;
    private String zip;
    private String state;
    private String number;
    private String complement;
    private String city;

    public Address(CreateAddress address) {
        this.publicArea = address.publicArea();
        this.neighborhood = address.neighborhood();
        this.zip = address.zip();
        this.state = address.state();
        this.complement = address.complement();
        this.number = address.number();
        this.city = address.city();
    }

    public void update(CreateAddress address) {
        if (address.publicArea() != null) {
            this.publicArea = address.publicArea();
        }
        if (address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if (address.zip() != null) {
            this.zip = address.zip();
        }
        if (address.state() != null) {
            this.state = address.state();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }
    }
}
