package com.atividade.pessoa.controller;

import com.atividade.pessoa.model.Pessoa;
import com.atividade.pessoa.request.PessoaRequest;
import com.atividade.pessoa.response.MessageResponse;
import com.atividade.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/all")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        List<Pessoa> pessoas = pessoaService.getAllPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pessoa> getPessoasById(@PathVariable("id") Integer id) {
        Pessoa pessoa = pessoaService.getAsSinglePessoa(id);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addPessoa(@RequestBody PessoaRequest pessoa) {
        MessageResponse newPessoa = pessoaService.createPessoa(pessoa);
        return new ResponseEntity<>(newPessoa, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public Optional<Pessoa> updatePessoa(@PathVariable Integer id, @RequestBody PessoaRequest pessoa) {
        return pessoaService.updatePessoa(id, pessoa);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePessoa (@PathVariable ("id")Integer id ) {
        pessoaService.deletePessoa(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
