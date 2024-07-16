package com.desafioTopicos.topicos.topicos;

import com.desafioTopicos.topicos.DatosActializarTopicos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Email;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Table (name = "topicos")
@Entity(name = "Topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode (of = "id")
public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //@Column(nullable = false, length = 255)
   // @NotNull
    private String titulo;

   // @Column(columnDefinition = "TEXT")
    //@NotNull
    private String mensaje;

    private String email;

    //@Column(name = "fecha_creacion")
    //@NotNull
    private LocalDate fecha_creacion;


   // @Enumerated(EnumType.STRING)
   // @NotNull
    private Status status;

    //@NotNull
    private String autor;

   // @NotNull
    private String curso;

    private Boolean activo;


   // @Email
   // @Column(nullable = false, unique = true)



    public Topicos(DatosTopicos datosTopicos) {
        this.activo = true;
        this.titulo = datosTopicos.titulo();
        this.mensaje = datosTopicos.mensaje();
        this.email = datosTopicos.email();
        this.fecha_creacion = datosTopicos.fecha_creacion();
        this.status = datosTopicos.status();
        this.autor = datosTopicos.autor();
        this.curso = datosTopicos.curso();

    }

    public void actualizar(DatosActializarTopicos datosActializarTopicos) {
        if (datosActializarTopicos.titulo() != null) {
            this.titulo = datosActializarTopicos.titulo();
        }
        if (datosActializarTopicos.mensaje() != null) {
            this.mensaje = datosActializarTopicos.mensaje();
        }
        if (datosActializarTopicos.fecha_creacion() != null) {
            this.fecha_creacion = datosActializarTopicos.fecha_creacion();
        }
        if (datosActializarTopicos.status() != null) {
            this.status = datosActializarTopicos.status();
        }
        if (datosActializarTopicos.autor() != null) {
            this.autor = datosActializarTopicos.autor();
        }
        if (datosActializarTopicos.curso() != null) {
            this.curso = datosActializarTopicos.curso();
        }

    }

    public void pausarTopico() {
        this.activo = false;

    }
}
