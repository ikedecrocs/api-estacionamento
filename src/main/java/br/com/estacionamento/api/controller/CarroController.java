package br.com.estacionamento.api.controller;

import br.com.estacionamento.api.dto.DadosAtualizacaoCarro;
import br.com.estacionamento.api.dto.DadosCadastroCarro;
import br.com.estacionamento.api.dto.DadosListagemCarro;
import br.com.estacionamento.api.model.Carro;
import br.com.estacionamento.api.service.CarroService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService service;

    @GetMapping
    public ResponseEntity<Object> listarCarros(Pageable paginacao) {
        try {
            return ResponseEntity.ok(service.listarCarros(paginacao));
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Object> adicionarCarro(@RequestBody @Valid DadosCadastroCarro dados) {
        try {
            service.adicionarCarro(dados);
            return ResponseEntity.created(null).build();
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @Transactional
    @PutMapping
    public ResponseEntity<Object> atualizarCarro(@RequestBody @Valid DadosAtualizacaoCarro dados) {
        try {
            service.atualizarCarro(dados);
            return ResponseEntity.ok(null);
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCarro(@PathVariable Long id) {
        try {
            service.excluirCarro(id);
            return ResponseEntity.ok(null);
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
