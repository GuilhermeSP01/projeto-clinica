package br.unip.projeto_clinica.controller;
import br.unip.projeto_clinica.model.usuario.Usuario;
import br.unip.projeto_clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/admin/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getTodosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable String id) {
    Optional<Usuario> usuario = usuarioService.getUsuarioPorId(id);
    if(usuario.isPresent()){
        return ResponseEntity.ok(usuario.get());
    } else {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sem conteúdo!");
    }
    }
    @PostMapping
    public ResponseEntity<Usuario> createIdoso(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable String id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuarioSalvo = usuarioService.atualizarUsuario(id, usuarioAtualizado);

        if (usuarioSalvo != null) {
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sem conteúdo!");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable String id) {
        if (usuarioService.deletarUsuario(id)) {
            return ResponseEntity.ok("Usuário deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sem conteúdo!");
        }
    }
}
