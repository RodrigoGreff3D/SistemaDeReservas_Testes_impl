package br.com.SistemaDeReservas_Testes_impl.Domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {

    public static final String REGEX_CEP = "[0-9]{5}-[0-9]{3}";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Pattern(regexp = REGEX_CEP, message = "O CEP deve ser informado no formato 99999-999.")
    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

}
