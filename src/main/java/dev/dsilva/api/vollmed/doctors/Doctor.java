package dev.dsilva.api.vollmed.doctors;

import dev.dsilva.api.vollmed.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Doctor")
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;

    private Specialty specialty;

    @Embedded
    private Address address;

    private Boolean active;


    public Doctor(CreateDoctor doctor) {
        this.active = true;
        this.name = doctor.name();
        this.email = doctor.email();
        this.phone = doctor.phone();
        this.crm = doctor.crm();
        this.specialty = doctor.specialty();
        this.address = new Address(doctor.address());
    }

    public void update(UpdateDoctorRequest request) {
        if (request.name() != null) {
            this.name = request.name();
        }
        if (request.phone() != null) {
            this.phone = request.phone();
        }
        if (request.address() != null) {
            this.address.update(request.address());
        }
    }

    public void remove() {
        this.active = false;
    }
}
