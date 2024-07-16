package com.desafioTopicos.topicos.controller;

import com.desafioTopicos.topicos.seguridad.AutenticacionService;
import com.desafioTopicos.topicos.seguridad.DatosJWTToken;
import com.desafioTopicos.topicos.seguridad.TokenServicios;
import com.desafioTopicos.topicos.usuario.DatosUsuarioAutenticacion;
import com.desafioTopicos.topicos.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
private AuthenticationManager authenticationManager;
    @Autowired
    private TokenServicios tokenServicios;


@PostMapping
    public ResponseEntity autenticacion(@RequestBody @Valid
                                        DatosUsuarioAutenticacion datosUsuarioAutenticacion)  {
    Authentication autenticarToken = new UsernamePasswordAuthenticationToken(datosUsuarioAutenticacion.login()
            ,datosUsuarioAutenticacion.clave());
     var UsuarioAutenticado =  authenticationManager.authenticate(autenticarToken);
    var JWTtoken = tokenServicios.generateToken((Usuario) UsuarioAutenticado.getPrincipal());
    return ResponseEntity.ok(new DatosJWTToken(JWTtoken));

}
}
