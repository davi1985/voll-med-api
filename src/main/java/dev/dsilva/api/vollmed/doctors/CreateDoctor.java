package dev.dsilva.api.vollmed.doctors;

import dev.dsilva.api.vollmed.dtos.CreateAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateDoctor(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String phone,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Specialty specialty,
        @NotNull @Valid CreateAddress address) {
}
