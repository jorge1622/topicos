package com.desafioTopicos.topicos.topicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosTopicos(
        @NotBlank String titulo,
        @NotBlank  String mensaje,
        @NotBlank
        @Email String email,
        @NotNull LocalDate fecha_creacion,
        @NotNull Status status,
        @NotBlank String autor,
        @NotBlank String curso
       )



{
}
