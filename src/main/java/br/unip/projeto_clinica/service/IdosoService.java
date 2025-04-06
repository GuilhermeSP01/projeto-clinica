package br.unip.projeto_clinica.service;

import br.unip.projeto_clinica.model.idoso.Idoso;
import br.unip.projeto_clinica.model.idoso.IdosoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IdosoService {
    private final IdosoRepository idosoRepository;

    public IdosoService(IdosoRepository idosoRepository) {
        this.idosoRepository = idosoRepository;
    }
    public List<Idoso> getTodosIdosos() {
        return idosoRepository.findAll();
    }
    public Optional<Idoso> getIdosoPorId(String id) {
        return idosoRepository.findById(id);
    }
    public Idoso salvarIdoso(Idoso idoso) {
        return idosoRepository.save(idoso);
    }
    public Idoso atualizarIdoso(String id, Idoso idosoAtualizado) {
        Optional<Idoso> idosoExistente = idosoRepository.findById(id);

        if (idosoExistente.isPresent()) {
            idosoAtualizado.setId(id);
            return idosoRepository.save(idosoAtualizado);
        } else {
            return null;
        }
    }
    public boolean deletarIdoso(String id) {
        if (idosoRepository.existsById(id)) {
            idosoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
