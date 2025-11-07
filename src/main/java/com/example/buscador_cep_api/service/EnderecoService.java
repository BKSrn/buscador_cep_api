package com.example.buscador_cep_api.service;

import com.example.buscador_cep_api.dto.CriarEnderecoDTO;
import com.example.buscador_cep_api.dto.EnderecoDadosApi;
import com.example.buscador_cep_api.dto.EnderecoResponseDTO;
import com.example.buscador_cep_api.exception.CepTamanhoException;
import com.example.buscador_cep_api.model.Endereco;
import com.example.buscador_cep_api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ApiService apiService;

    @Autowired
    ConverteJsonService converteJsonService;

    public EnderecoResponseDTO criarEndereco(CriarEnderecoDTO dto) {
        if (dto.cep().length() < 8){
            throw new CepTamanhoException("Esta faltando caracteres no cep");
        } else if (dto.cep().length() > 8) {
            throw new CepTamanhoException("Esta sobrando caracteres no cep");
        }

        String json = apiService.getJson(dto.cep());
        EnderecoDadosApi enderecoDados = converteJsonService.fromJson(json, EnderecoDadosApi.class);

        Endereco endereco = enderecoRepository.save(new Endereco(enderecoDados.logradouro(), enderecoDados.bairro(),
                enderecoDados.localidade(), enderecoDados.cep()));
        return converterParaDto(endereco);
    }

    private EnderecoResponseDTO converterParaDto(Endereco endereco){
        return new EnderecoResponseDTO(endereco.getLogradouro(), endereco.getBairro(),
                endereco.getLocalidade(), endereco.getCep());
    }
}
