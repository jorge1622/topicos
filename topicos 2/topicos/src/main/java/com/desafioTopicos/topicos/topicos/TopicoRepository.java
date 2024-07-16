package com.desafioTopicos.topicos.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository <Topicos, Long> {

    Page<Topicos> findByActivoTrue(Pageable pageable);


}
