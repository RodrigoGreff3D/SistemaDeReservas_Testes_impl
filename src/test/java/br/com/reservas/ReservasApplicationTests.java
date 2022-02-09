package br.com.reservas;

import br.com.reservas.domain.Usuario;
import br.com.reservas.usuario.exception.RecursoJaExistenteException;
import br.com.reservas.usuario.repository.UsuarioRepository;
import br.com.reservas.usuario.service.CadastrarUsuarioService;
import br.com.reservas.usuario.service.UsuarioTestHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ReservasApplicationTests {

    @InjectMocks
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Captor
    private ArgumentCaptor<Usuario> usuarioArgumentCaptor;

    @Test
    public void deveLancarExceptionQuandoUsuarioComEmailDuplicadoTest() {
        Usuario usuario = UsuarioTestHelper.criaUsuarioValido();

        when(usuarioRepository.existsByEmail(usuario.getEmail())).thenReturn(true);
        RecursoJaExistenteException recursoJaExistenteException = assertThrows(RecursoJaExistenteException.class, () -> {
            cadastrarUsuarioService.cadastrarUsuario(usuario);
        });
        assertTrue(recursoJaExistenteException.toString().contains(usuario.getEmail()));
    }

    @Test
    public void deveLancarExceptionQuandoUsuarioComCpfDuplicadoTest() {
        Usuario usuario = UsuarioTestHelper.criaUsuarioValido();

        when(usuarioRepository.existsByCpf(usuario.getCpf())).thenReturn(true);
        RecursoJaExistenteException recursoJaExistenteException = assertThrows(RecursoJaExistenteException.class, () -> {
            cadastrarUsuarioService.cadastrarUsuario(usuario);
        });
        assertTrue(recursoJaExistenteException.toString().contains(usuario.getEmail()));
    }

    @Test
    public void deveSalvarUsuarioTest() {
        Usuario usuario = UsuarioTestHelper.criaUsuarioValido();

        when(usuarioRepository.save(usuarioArgumentCaptor.capture())).thenReturn(usuario);
        cadastrarUsuarioService.cadastrarUsuario(usuario);

        assertEquals(usuario, usuarioArgumentCaptor.getValue());
    }

}
