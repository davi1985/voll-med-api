package dev.dsilva.api.vollmed.domain.doctors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Specialty {
    ORTHOPEDICS("Ortopedia"),
    CARDIOLOGY("Cardiologia"),
    GYNECOLOGY("Ginecologia"),
    DERMATOLOGY("Dermatologia");

    private final String value;

    Specialty(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Specialty fromValue(String value) {
        for (Specialty specialty : values()) {
            if (specialty.getValue().equalsIgnoreCase(value)) {
                return specialty;
            }
        }

        throw new IllegalArgumentException("Unknown specialty: " + value);
    }
}
