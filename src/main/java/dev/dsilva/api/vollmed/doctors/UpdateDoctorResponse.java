package dev.dsilva.api.vollmed.doctors;

import dev.dsilva.api.vollmed.address.Address;

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
