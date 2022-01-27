package br.com.SistemaDeReservas_Testes_impl.controller;

import br.com.SistemaDeReservas_Testes_impl.Domain.Usuario;
import br.com.SistemaDeReservas_Testes_impl.Service.UsuarioService.CadastrarUsuarioService;
import br.com.SistemaDeReservas_Testes_impl.Service.UsuarioService.ListarUsuarioService;
import br.com.SistemaDeReservas_Testes_impl.controller.Request.UsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class CadastroUsuarioController {

    @Autowired
    public CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    public ListarUsuarioService listarUsuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario) {
        cadastrarUsuarioService.cadastrar(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public Page<Usuario> listarUsuarios(@PageableDefault(sort = "nome")Pageable pageable){
        return listarUsuarioService.listar(pageable);
    }
}
