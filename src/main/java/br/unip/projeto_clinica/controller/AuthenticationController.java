package br.unip.projeto_clinica.controller;

import br.unip.projeto_clinica.model.jwt.JwtRequest;
import br.unip.projeto_clinica.model.jwt.JwtResponse;
import br.unip.projeto_clinica.model.usuario.Usuario;
import br.unip.projeto_clinica.model.usuario.UserRepository;
import br.unip.projeto_clinica.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public AuthenticationController(TokenService tokenService, UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        if(usuario.getEmail() == null || usuario.getSenha() == null)
            return ResponseEntity.badRequest().body("Faltando nome de usuário ou senha");

        if(userRepository.findByEmail(usuario.getEmail()).isPresent())
            return ResponseEntity.badRequest().body("Nome de usuário indisponível");

        usuario.setSenha(encoder.encode(usuario.getSenha()));
        usuario.setRoles(List.of(() -> "USER"));
        userRepository.save(usuario);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        var authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        jwtRequest.username(),
                        jwtRequest.password()
                );

        var authentication =
                authenticationManager.authenticate(authenticationToken);

        var token =
                tokenService.generateToken(authentication);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/newAdmin")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> newAdmin(String username) {
        if(username == null)
            return ResponseEntity.badRequest().body("Forneça o nome de usuário");

        Usuario usuario = userRepository.findByEmail(username).orElse(null);

        if(usuario == null)
            return ResponseEntity.badRequest().body("Usuário não encontrado");

        usuario.setRoles(List.of(() -> "ADMIN"));
        userRepository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
