package br.unip.projeto_clinica.controller;

import br.unip.projeto_clinica.model.idoso.Idoso;
import br.unip.projeto_clinica.model.usuario.Usuario;
import br.unip.projeto_clinica.service.IdosoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/admin/idosos")
public class IdosoController {
    private final IdosoService idosoService;

    @Autowired
    public IdosoController(IdosoService idosoService) {
        this.idosoService = idosoService;
    }

    @GetMapping
    public List<Idoso> getAllIdosos() {
        return idosoService.getTodosIdosos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIdosoById(@PathVariable String id) {
        Optional<Idoso> usuario = idosoService.getIdosoPorId(id);
        if(usuario.isPresent()){
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sem conteúdo!");
        }
    }

    @PostMapping
    public ResponseEntity<Idoso> createIdoso(@RequestBody Idoso idoso) {
        Idoso novoIdoso = idosoService.salvarIdoso(idoso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIdoso);
    }

    @PutMapping("/{id}")
        public ResponseEntity<?> atualizarIdoso(@PathVariable String id, @RequestBody Idoso idosoAtualizado) {
            Idoso idosoSalvo = idosoService.atualizarIdoso(id, idosoAtualizado);

            if (idosoSalvo != null) {
                return ResponseEntity.ok("Usuário atualizado com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sem conteúdo!");
            }
        }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIdoso(@PathVariable String id) {
        if (idosoService.deletarIdoso(id)) {
            return ResponseEntity.ok("Usuário deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Sem conteúdo!");
        }
    }
    }
