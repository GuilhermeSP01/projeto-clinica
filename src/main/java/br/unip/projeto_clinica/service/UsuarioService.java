package br.unip.projeto_clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.projeto_clinica.model.usuario.Usuario;
import br.unip.projeto_clinica.model.usuario.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private EmailService emailService;

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
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        
        // Envia e-mail após salvar o usuário
        emailService.enviarEmailTexto(
            usuario.getEmail(), 
            "Email enviado", 
            "Usuário cadastrado com sucesso"
        );

        return usuarioSalvo;
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
