package com.desafioTopicos.topicos.tratamientoErrores;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamientoDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
   public ResponseEntity tratamientoErrores(){
       return ResponseEntity.notFound().build();
   }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratamientoErrores40040(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(valodacionErrores::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    private  record valodacionErrores(  String campo  , String mensajeErro  ){
        public valodacionErrores(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
    }
}
