package br.com.SistemaDeReservas_Testes_impl.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @Size(min = 11, max = 11, message = "O CPF deve ser informado no formato 99999999999.")
    @Pattern(regexp = "[0-9]+", message = "O CPF deve ser informado no formato 99999999999.")
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    @Valid
    private Endereco endereco;

}
