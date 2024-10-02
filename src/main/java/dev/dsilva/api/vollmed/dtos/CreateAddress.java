package dev.dsilva.api.vollmed.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAddress(
        @NotBlank String publicArea,
        @NotBlank String neighborhood,
        @NotBlank @Pattern(regexp = "\\d{8}") String zip,
        @NotBlank String state,
        @NotBlank String city,
        String number,
        String complement) {
}
