package br.com.SistemaDeReservas_Testes_impl.Service.UsuarioService;

import br.com.SistemaDeReservas_Testes_impl.Domain.Usuario;
import br.com.SistemaDeReservas_Testes_impl.Exception.RecursoJaExistenteException;
import br.com.SistemaDeReservas_Testes_impl.Repository.UsuarioRepository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

//    @Autowired
//    public ModelMapper modelMapper;


    public void cadastrar(Usuario usuario) {
        validaUsuario(usuario);

        usuarioRepository.save(usuario);
    }


    private void validaUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RecursoJaExistenteException(Usuario.class, usuario.getEmail(), "E-Mail");

        }
        if(usuarioRepository.existsByCpf(usuario.getCpf())){
            throw new RecursoJaExistenteException(Usuario.class, usuario.getCpf(), "CPF");
        }
    }

//    private Usuario converteParaObjeto(UsuarioRequest usuarioRequest) {
//        Usuario usuario = modelMapper.map(usuarioRequest, Usuario.class);
//        return usuario;
//    }

}
