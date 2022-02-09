package br.com.reservas.usuario.service;

import br.com.reservas.domain.Usuario;
import br.com.reservas.usuario.exception.RecursoJaExistenteException;
import br.com.reservas.usuario.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarUsuarioServiceTest {

    @InjectMocks
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Captor
    private ArgumentCaptor<Usuario> captor;

    @Test
    public void deveriaLancarExceptionQuandoUsuarioComEmailDuplicadoTest() {
        Usuario usuario = UsuarioTestHelper.criaUsuarioValido();

        when(usuarioRepository.existsByEmail(usuario.getEmail())).thenReturn(true);
        RecursoJaExistenteException recursoJaExistenteException = assertThrows(RecursoJaExistenteException.class, () -> {
                    cadastrarUsuarioService.cadastrarUsuario(usuario);
                });
        assertTrue(recursoJaExistenteException.toString().contains(usuario.getEmail()));
    }

    @Test
    public void deveriaLancarExceptionQuandoUsuarioComCpfDuplicadoTest() {
        Usuario usuario = UsuarioTestHelper.criaUsuarioValido();

        when(usuarioRepository.existsByCpf(usuario.getCpf())).thenReturn(true);
        RecursoJaExistenteException recursoJaExistenteException = assertThrows(RecursoJaExistenteException.class, () -> {
            cadastrarUsuarioService.cadastrarUsuario(usuario);
        });
        assertTrue(recursoJaExistenteException.toString().contains(usuario.getCpf()));
    }

    @Test
    public void deveSalvarUmUsuario(){
        Usuario usuario = UsuarioTestHelper.criaUsuarioValido();

        when(usuarioRepository.save(captor.capture())).thenReturn(usuario);
        cadastrarUsuarioService.cadastrarUsuario(usuario);

        assertEquals(usuario, captor.getValue());

    }

}
