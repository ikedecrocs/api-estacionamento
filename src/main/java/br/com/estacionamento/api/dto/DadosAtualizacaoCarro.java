package br.com.estacionamento.api.dto;

import br.com.estacionamento.api.model.Cliente;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCarro(
        @NotNull
        Long id,
        String placa,
        String marca,
        String modelo,
        Cliente dono
) {
}
