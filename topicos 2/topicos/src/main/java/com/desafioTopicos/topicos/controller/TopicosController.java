package com.desafioTopicos.topicos.controller;

import com.desafioTopicos.topicos.DatosActializarTopicos;
import com.desafioTopicos.topicos.topicos.ActulizarTopicosDto;
import com.desafioTopicos.topicos.topicos.DatosTopicos;
import com.desafioTopicos.topicos.topicos.TopicoRepository;
import com.desafioTopicos.topicos.topicos.Topicos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity<ActulizarTopicosDto> registraTopicos(@RequestBody  @Valid DatosTopicos datosTopicos,
                                                               UriComponentsBuilder uriBuilder) {
     Topicos topicos =  topicoRepository.save(new Topicos(datosTopicos));
     ActulizarTopicosDto actulizarTopicosDto = new ActulizarTopicosDto(topicos.getId(),topicos.getTitulo()
             ,topicos.getMensaje(),topicos.getEmail(),topicos.getFecha_creacion(),
             topicos.getStatus(),topicos.getAutor(),topicos.getCurso());
        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topicos.getId()).toUri();
     return ResponseEntity.created(url).body(actulizarTopicosDto);
    }

    @GetMapping
    public ResponseEntity<Page<Topicos>>  listaTopicos( @PageableDefault(size = 10 ) Pageable pageable){
        //return topicoRepository.findByActivoTrue(pageable);
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(pageable));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopicos( @Valid @RequestBody DatosActializarTopicos datosActializarTopicos ){
        Topicos topicos = topicoRepository.getReferenceById(datosActializarTopicos.id());
        topicos.actualizar(datosActializarTopicos);
                return ResponseEntity.ok(new ActulizarTopicosDto(topicos.getId(),topicos.getTitulo()
                ,topicos.getMensaje(),topicos.getEmail(),topicos.getFecha_creacion(),
                        topicos.getStatus(),topicos.getAutor(),topicos.getCurso()));

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminaTopicos(@PathVariable Long id){
        Topicos topicos = topicoRepository.getReferenceById(id);
       // topicoRepository.delete(topicos);
        topicos.pausarTopico();
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<ActulizarTopicosDto> devulveDatosTopico (@PathVariable Long id){
        Topicos topicos = topicoRepository.getReferenceById(id);
        var datosTopico = (new ActulizarTopicosDto(topicos.getId(),topicos.getTitulo()
                ,topicos.getMensaje(),topicos.getEmail(),topicos.getFecha_creacion(),
                topicos.getStatus(),topicos.getAutor(),topicos.getCurso()));
        return ResponseEntity.ok(datosTopico);



    }




}



