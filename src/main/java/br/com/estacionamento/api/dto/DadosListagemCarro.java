package br.com.estacionamento.api.dto;

import br.com.estacionamento.api.model.Carro;
import br.com.estacionamento.api.model.Cliente;

public record DadosListagemCarro(
        Long id,
        String placa,
        Cliente dono
) {
    public DadosListagemCarro(Carro carro) {
        this(carro.getId(), carro.getPlaca(), carro.getDono());
    }
}
