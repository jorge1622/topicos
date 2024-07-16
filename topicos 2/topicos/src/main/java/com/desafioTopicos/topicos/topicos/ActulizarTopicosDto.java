package com.desafioTopicos.topicos.topicos;

import java.time.LocalDate;

public record ActulizarTopicosDto(Long id ,
                                  String titulo,
                                  String mensaje,
                                  String email, LocalDate fecha_creacion,
                                  Status status,
                                  String autor,
                                  String curso  ) {
}
