package br.com.estacionamento.api.controller;

import br.com.estacionamento.api.dto.DadosAtualizacaoCliente;
import br.com.estacionamento.api.dto.DadosListagemCliente;
import br.com.estacionamento.api.dto.DadosCadastroCliente;
import br.com.estacionamento.api.model.Cliente;
import br.com.estacionamento.api.repository.ClienteRepository;
import br.com.estacionamento.api.service.ClienteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public ResponseEntity<Object> listarClientes(Pageable paginacao) {
        try {
            return ResponseEntity.ok(service.listarClientes(paginacao));
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> adicionarClientes(@RequestBody @Valid DadosCadastroCliente dados) {
        try {
            service.adicionarCliente(dados);
            return ResponseEntity.created(null).build();
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @Transactional
    @PutMapping
    public ResponseEntity<Object> atualizarClientes(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        try {
            service.atualizarCliente(dados);
            return ResponseEntity.ok(null);
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCliente(@PathVariable Long id) {
        try {
            service.excluirCliente(id);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
