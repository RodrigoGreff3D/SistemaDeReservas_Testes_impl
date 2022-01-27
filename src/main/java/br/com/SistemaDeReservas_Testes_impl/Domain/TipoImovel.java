package br.com.SistemaDeReservas_Testes_impl.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoImovel {

    APARTAMENTO("Apartamento"),
    CASA("Casa"),
    HOTEL("Hotel"),
    POUSADA("Pousada");

    private String descricao;

}
