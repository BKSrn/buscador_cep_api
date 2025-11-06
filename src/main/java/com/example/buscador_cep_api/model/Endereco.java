package com.example.buscador_cep_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cep's")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String cep;

    public Endereco() {
    }

    public Endereco(String logradouro, String bairro, String localidade, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
