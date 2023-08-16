package br.com.estacionamento.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
    @NotBlank
    String nome,
    @NotBlank
    @Pattern(regexp = "\\d{11}")
    String cpf,
    @NotBlank
    String endereco,
    @NotBlank
    @Pattern(regexp = "\\d{8,11}")
    String telefone,
    @NotBlank
    @Email
    String email
) {

}
