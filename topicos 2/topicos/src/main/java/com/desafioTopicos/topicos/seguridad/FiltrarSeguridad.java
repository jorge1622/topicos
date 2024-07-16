package com.desafioTopicos.topicos.seguridad;

import com.desafioTopicos.topicos.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FiltrarSeguridad extends OncePerRequestFilter {
    @Autowired
    private TokenServicios tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal
               (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var autenHeader = request.getHeader("Authorization");
        if (autenHeader != null) {
          var  token = autenHeader.replace("Bearer ", "");
            var subJect = tokenService.getSubject(token);
            if (subJect != null) {
                var  usuario = usuarioRepository.findByLogin(subJect);
                var autenticacion = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autenticacion) ;
            }


        }
        filterChain.doFilter(request, response);

    }
}
