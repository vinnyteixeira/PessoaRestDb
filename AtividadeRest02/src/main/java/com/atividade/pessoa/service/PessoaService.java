package com.atividade.pessoa.service;

import com.atividade.pessoa.model.Pessoa;
import com.atividade.pessoa.request.PessoaRequest;
import com.atividade.pessoa.response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    MessageResponse createPessoa(PessoaRequest pessoaRequest);

    Optional<Pessoa> updatePessoa(Integer pessoaId, PessoaRequest pessoaRequest);

    void deletePessoa(Integer pessoaId);

    Pessoa getAsSinglePessoa(Integer pessoaId);

    List<Pessoa> getAllPessoas();
}
