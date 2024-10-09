package dev.dsilva.api.vollmed.domain.doctors.dtos;

import dev.dsilva.api.vollmed.domain.address.Address;
import dev.dsilva.api.vollmed.domain.doctors.Doctor;
import dev.dsilva.api.vollmed.domain.doctors.Specialty;

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