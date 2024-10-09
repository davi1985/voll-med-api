package dev.dsilva.api.vollmed.doctors;

public record DoctorResponse(String name, String email, String crm, Specialty specialty) {
    public DoctorResponse(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
