package br.com.estacionamento.api.model;

import br.com.estacionamento.api.dto.DadosAtualizacaoCarro;
import br.com.estacionamento.api.dto.DadosCadastroCarro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "carros")
@Entity(name = "Carro")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    @ManyToOne
    @JoinColumn(name="id_dono")
    private Cliente dono;

    public Carro(DadosCadastroCarro dados) {
        this.placa = dados.placa();
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.dono = dados.dono();
    }

    public void atualizarInformacoes(DadosAtualizacaoCarro dados) {
        if (dados.placa() != null) {
            this.placa = dados.placa();
        }
        if (dados.marca() != null) {
            this.marca = dados.marca();
        }
        if (dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
        if (dados.dono() != null) {
            this.dono = dados.dono();
        }
    }
}
