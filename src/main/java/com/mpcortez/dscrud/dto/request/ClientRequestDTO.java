package com.mpcortez.dscrud.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientRequestDTO(Long id,
                               @NotBlank
                               String name,
                               String cpf,
                               Double income,
                               @PastOrPresent
                               LocalDate birthDate,
                               Integer children) {
}
