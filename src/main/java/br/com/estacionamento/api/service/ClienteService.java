package br.com.estacionamento.api.service;

import br.com.estacionamento.api.dto.DadosAtualizacaoCliente;
import br.com.estacionamento.api.dto.DadosCadastroCliente;
import br.com.estacionamento.api.dto.DadosListagemCliente;
import br.com.estacionamento.api.model.Cliente;
import br.com.estacionamento.api.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Page<DadosListagemCliente> listarClientes(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCliente::new);
    }

    public void adicionarCliente(DadosCadastroCliente dados) {
        repository.save(new Cliente(dados));
    }

    public void atualizarCliente(DadosAtualizacaoCliente dados) {
        var cliente = repository.getReferenceById(dados.id());
        System.out.println(cliente.getId());
        cliente.atualizarInformacoes(dados);
    }

    public void excluirCliente(Long id) {
        repository.deleteById(id);
    }
}
