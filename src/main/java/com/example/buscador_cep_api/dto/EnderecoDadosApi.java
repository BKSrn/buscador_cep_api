package com.example.buscador_cep_api.dto;

public record EnderecoDadosApi(String cep,
                               String logradouro,
                               String bairro,
                               String localidade) {

}
