package br.com.reservas.usuario.service;

import br.com.reservas.domain.Usuario;
import br.com.reservas.usuario.exception.RecursoNaoEncontradoException;
import br.com.reservas.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<Usuario> listarUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException(Usuario.class, id, "Id"));
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RecursoNaoEncontradoException(Usuario.class, cpf, "Cpf"));
    }
}
