package dev.dsilva.api.vollmed.domain.doctors.dtos;

import dev.dsilva.api.vollmed.domain.address.Address;
import dev.dsilva.api.vollmed.domain.doctors.Doctor;
import dev.dsilva.api.vollmed.domain.doctors.Specialty;

public record UpdateDoctorResponse(
        Long id,
        String name,
        String email,
        String crm,
        String phone,
        Specialty specialty,
        Address address
) {
    public UpdateDoctorResponse(Doctor doctor) {
        this(doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getPhone(),
                doctor.getSpecialty(),
                doctor.getAddress()
        );
    }
}
