package dev.dsilva.api.vollmed.doctors;

public record GetDoctor(String name, String email, String crm, Specialty specialty) {
    public GetDoctor(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
