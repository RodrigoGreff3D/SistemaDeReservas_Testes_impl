package br.com.SistemaDeReservas_Testes_impl.Service.UsuarioService;

import br.com.SistemaDeReservas_Testes_impl.Domain.Usuario;
import br.com.SistemaDeReservas_Testes_impl.Repository.UsuarioRepository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarUsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;


    public Page<Usuario> listar(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
}
