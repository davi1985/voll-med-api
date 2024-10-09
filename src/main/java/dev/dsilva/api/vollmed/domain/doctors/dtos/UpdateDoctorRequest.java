package dev.dsilva.api.vollmed.domain.doctors.dtos;

import dev.dsilva.api.vollmed.dtos.CreateAddress;
import jakarta.validation.constraints.NotNull;

public record UpdateDoctorRequest(
        @NotNull
        Long id,
        String name,
        String phone,
        CreateAddress address) {
}
