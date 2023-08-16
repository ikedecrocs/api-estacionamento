package br.com.estacionamento.api.service;

import br.com.estacionamento.api.dto.DadosAtualizacaoCarro;
import br.com.estacionamento.api.dto.DadosCadastroCarro;
import br.com.estacionamento.api.dto.DadosListagemCarro;
import br.com.estacionamento.api.model.Carro;
import br.com.estacionamento.api.repository.CarroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CarroService {

    @Autowired
    CarroRepository repository;

    public Page<DadosListagemCarro> listarCarros(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCarro::new);
    }

    public void adicionarCarro(DadosCadastroCarro dados) {
        repository.save(new Carro(dados));
    }

    public void atualizarCarro(DadosAtualizacaoCarro dados) {
        var carro = repository.getReferenceById(dados.id());
        carro.atualizarInformacoes(dados);
    }

    public void excluirCarro(Long id) {
        repository.deleteById(id);
    }
}
