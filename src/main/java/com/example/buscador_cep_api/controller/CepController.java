package com.example.buscador_cep_api.controller;

import com.example.buscador_cep_api.dto.CriarEnderecoDTO;
import com.example.buscador_cep_api.dto.EnderecoResponseDTO;
import com.example.buscador_cep_api.exception.CepTamanhoException;
import com.example.buscador_cep_api.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ceps")
public class CepController {

    @Autowired
    private CepService cepService;

    @PostMapping("/criar/")
    public ResponseEntity<EnderecoResponseDTO> criarEnderecoPeloCep(@RequestBody CriarEnderecoDTO dto){
        try {
            EnderecoResponseDTO enderecoResponseDTO = cepService.criarEndereco(dto);
            return ResponseEntity.status(HttpStatus.OK).body(enderecoResponseDTO);
        }catch (CepTamanhoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
