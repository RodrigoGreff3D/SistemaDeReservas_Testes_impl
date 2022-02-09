package br.com.reservas.usuario.service;

import br.com.reservas.domain.Endereco;
import br.com.reservas.domain.Usuario;

import java.time.LocalDate;

public class UsuarioTestHelper {

    public static Usuario criaUsuarioValido(){
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario Valido 1");
        usuario.setEmail("usuario1@valido.com");
        usuario.setSenha("senhausuariovalido");
        usuario.setCpf("11111111111");
        usuario.setEndereco(criarEnderecoValido());
        usuario.setDataNascimento(LocalDate.of(1988, 9, 10));
        return usuario;
    }

    public static Endereco criarEnderecoValido() {
        return Endereco.builder()
                .cep("051412001")
                .cidade("Cidade Valida")
                .estado("Estado Valido")
                .numero("123")
                .logradouro("Rua Vaida")
                .bairro("Bairro Valido")
                .build();
    }
}
