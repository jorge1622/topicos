package com.desafioTopicos.topicos;

import com.desafioTopicos.topicos.topicos.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosActializarTopicos(@NotNull Long id ,
                                     String titulo,
                                     String mensaje,
                                     LocalDate fecha_creacion,
                                     Status status,
                                     String autor,
                                     String curso  )   {
}
