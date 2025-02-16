package br.unip.projeto_clinica.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/hello-admin")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String helloAdmin() {
        return "Hello Admin!";
    }
}
