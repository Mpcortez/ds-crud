package com.mpcortez.dscrud.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ClientResponseDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
}
