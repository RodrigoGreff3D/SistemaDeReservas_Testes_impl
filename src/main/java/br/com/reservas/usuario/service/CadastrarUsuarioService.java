package br.com.reservas.usuario.service;

import br.com.reservas.domain.Usuario;
import br.com.reservas.usuario.exception.RecursoJaExistenteException;
import br.com.reservas.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(Usuario usuario) {
        validaUsuario(usuario);
        usuarioRepository.save(usuario);
    }

    private void validaUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RecursoJaExistenteException(Usuario.class, usuario.getEmail(), "E-mail");
        }
        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new RecursoJaExistenteException(Usuario.class, usuario.getCpf(), "CPF");
        }
    }


}
