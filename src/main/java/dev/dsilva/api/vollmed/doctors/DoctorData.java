package dev.dsilva.api.vollmed.doctors;

import dev.dsilva.api.vollmed.address.Address;

public record DoctorData(
        Long id,
        String name,
        String email,
        String crm,
        Specialty specialty,
        Address address) {

    public DoctorData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty(), doctor.getAddress());
    }
}