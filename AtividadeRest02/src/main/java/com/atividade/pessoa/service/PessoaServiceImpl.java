package com.atividade.pessoa.service;

import com.atividade.pessoa.model.Pessoa;
import com.atividade.pessoa.repository.PessoaRepository;
import com.atividade.pessoa.request.PessoaRequest;
import com.atividade.pessoa.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService{
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public MessageResponse createPessoa (PessoaRequest pessoaRequest) {
        Pessoa newPessoa = new Pessoa();

        newPessoa.setNome(pessoaRequest.getNome());
        newPessoa.setCpf(pessoaRequest.getCpf());
        newPessoa.setRg(pessoaRequest.getRg());
        newPessoa.setDataNasc(pessoaRequest.getDataNasc());
        newPessoa.setEstadoCiv(pessoaRequest.getEstadoCiv());
        newPessoa.setTel(pessoaRequest.getTel());
        newPessoa.setEmail(pessoaRequest.getEmail());

        pessoaRepository.save(newPessoa);

        return new MessageResponse("pessoa cadastrada com sucesso");

    }

    @Override
    public Optional<Pessoa> updatePessoa (Integer pessoaId, PessoaRequest pessoaRequest) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);

        if(pessoa.isEmpty()) {
            throw new RuntimeException();
        }
        else
            pessoa.get().setNome(pessoaRequest.getNome());
            pessoa.get().setCpf(pessoaRequest.getCpf());
            pessoa.get().setRg(pessoaRequest.getRg());
            pessoa.get().setDataNasc(pessoaRequest.getDataNasc());
            pessoa.get().setEstadoCiv(pessoaRequest.getEstadoCiv());
            pessoa.get().setTel(pessoaRequest.getTel());
            pessoa.get().setEmail(pessoaRequest.getEmail());
            pessoaRepository.save(pessoa.get());

        return pessoa;
    }

    @Override
    public Pessoa getAsSinglePessoa(Integer pessoaId) {
        return pessoaRepository.findById(pessoaId).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<Pessoa> getAllPessoas(){
        return pessoaRepository.findAll();
    }

    @Override
    public void deletePessoa(Integer pessoaId) {
        if(pessoaRepository.getById(pessoaId).getId().equals(pessoaId)){
            pessoaRepository.deleteById(pessoaId);
        }
        else throw new RuntimeException();
    }
}
