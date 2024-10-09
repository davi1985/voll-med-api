package dev.dsilva.api.vollmed.domain.doctors.dtos;

import dev.dsilva.api.vollmed.domain.doctors.Doctor;
import dev.dsilva.api.vollmed.domain.doctors.Specialty;

public record DoctorResponse(String name, String email, String crm, Specialty specialty) {
    public DoctorResponse(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
