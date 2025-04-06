package br.unip.projeto_clinica.service;
import br.unip.projeto_clinica.model.usuario.Usuario;
import br.unip.projeto_clinica.model.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public List<Usuario> getTodosUsuarios() {
        return usuarioRepository.findAll();
    }
    public Optional<Usuario> getUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Usuario atualizarUsuario(String id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            usuarioAtualizado.setId(id);
            return usuarioRepository.save(usuarioAtualizado);
        } else {
            return null;
        }
    }
    public boolean deletarUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
