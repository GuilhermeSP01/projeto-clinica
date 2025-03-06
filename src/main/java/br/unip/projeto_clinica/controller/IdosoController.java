package br.unip.projeto_clinica.controller;

import br.unip.projeto_clinica.model.idoso.Idoso;
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
    public Optional<Idoso> getIdosoById(@PathVariable Long id) {
        return idosoService.getIdosoPorId(id);
    }

    @PostMapping
    public ResponseEntity<Idoso> createIdoso(@RequestBody Idoso idoso) {
        Idoso novoIdoso = idosoService.salvarIdoso(idoso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoIdoso);
    }

    @PutMapping("/{id}")
        public ResponseEntity<Idoso> atualizarIdoso(@PathVariable Long id, @RequestBody Idoso idosoAtualizado) {
            Idoso idosoSalvo = idosoService.atualizarIdoso(id, idosoAtualizado);

            if (idosoSalvo != null) {
                return ResponseEntity.ok(idosoSalvo);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIdoso(@PathVariable Long id) {
        if (idosoService.deletarIdoso(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }
