package br.com.reservas.usuario.controller;

import br.com.reservas.domain.Usuario;
import br.com.reservas.usuario.service.BuscarUsuariosService;
import br.com.reservas.usuario.service.CadastrarUsuarioService;
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
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioService usuarioService;

    @Autowired
    private BuscarUsuariosService buscarUsuariosService;


    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public Page<Usuario> listarUsuarios(@PageableDefault(sort = "nome") Pageable pageable) {
        return buscarUsuariosService.listarUsuarios(pageable);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable("idUsuario") Long id) {
        Usuario usuario = buscarUsuariosService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Usuario> buscarUsuarioPorCpf(@PathVariable("cpf") String cpf) {
        Usuario usuario = buscarUsuariosService.buscarUsuarioPorCpf(cpf);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
