package br.com.SistemaDeReservas_Testes_impl.controller.Request;

import br.com.SistemaDeReservas_Testes_impl.Domain.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioRequest {

    private String nome;

    private String email;

    private String senha;

    private String cpf;

    private LocalDate dataNascimento;

    private Endereco endereco;
}
