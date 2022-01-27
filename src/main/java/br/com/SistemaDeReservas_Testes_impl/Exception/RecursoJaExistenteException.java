package br.com.SistemaDeReservas_Testes_impl.Exception;

import br.com.SistemaDeReservas_Testes_impl.Domain.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotBlank;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecursoJaExistenteException extends RuntimeException {

    public RecursoJaExistenteException(Class clazz, Object id, String descricao) {
        super(String.format("Já existe um recurso do tipo %s com %s com o valor '%s'.", clazz.getSimpleName(), descricao, id));
    }

}
