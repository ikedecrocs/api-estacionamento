package br.com.estacionamento.api.dto;

import br.com.estacionamento.api.model.Cliente;

public record DadosListagemCliente(
        Long id,
        String nome,
        String telefone,
        String email
) {

    public DadosListagemCliente(Cliente dados) {
        this(dados.getId(), dados.getNome(), dados.getTelefone(), dados.getEmail());
    }

}
