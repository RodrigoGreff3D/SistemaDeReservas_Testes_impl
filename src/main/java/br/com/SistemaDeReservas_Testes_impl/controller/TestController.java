package br.com.SistemaDeReservas_Testes_impl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/reservas")
    public String teste() {
        return "Teste";
    }
}
