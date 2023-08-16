package br.com.estacionamento.api.dto;

import br.com.estacionamento.api.model.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCarro(
        @NotBlank
        @Pattern(regexp="\\d{7}")
        String placa,
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @NotNull
        Cliente dono
) {
}
