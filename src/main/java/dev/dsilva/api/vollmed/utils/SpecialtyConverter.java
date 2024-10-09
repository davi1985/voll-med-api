package dev.dsilva.api.vollmed.utils;

import dev.dsilva.api.vollmed.domain.doctors.Specialty;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SpecialtyConverter implements AttributeConverter<Specialty, String> {

    @Override
    public String convertToDatabaseColumn(Specialty specialty) {
        return specialty != null ? specialty.getValue() : null;
    }

    @Override
    public Specialty convertToEntityAttribute(String value) {
        return value != null ? Specialty.fromValue(value) : null;
    }
}
