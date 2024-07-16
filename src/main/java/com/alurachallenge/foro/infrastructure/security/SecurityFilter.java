package com.alurachallenge.foro.infrastructure.security;

import com.alurachallenge.foro.infrastructure.service.TokenService;
import jakarta.persistence.Access;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.rmi.RemoteException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = request.getHeader("Authorization");
        if(token == null || token == ""){
            throw new RemoteException("El token enviado no es válido");
        }
        token = token.replace("Bearer ", "");
        System.out.println(token);
        System.out.println(tokenService.getSubject(token));
        filterChain.doFilter(request,response);
    }
}
