package com.example.buscador_cep_api.dto;

public record EnderecoResponseDTO(String logradouro,
                                  String bairro,
                                  String localidade,
                                  String cep) {
}
