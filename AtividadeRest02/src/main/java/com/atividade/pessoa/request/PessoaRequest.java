package com.atividade.pessoa.request;

import com.atividade.pessoa.model.estadoCiv;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {

    @NotBlank
    @NotNull
    private String Nome;
    @NotBlank
    @NotNull
    private Long cpf;
    @NotBlank
    @NotNull
    private Long rg;
    @NotBlank
    @NotNull
    private LocalDateTime dataNasc;
    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private com.atividade.pessoa.model.estadoCiv estadoCiv;
    @NotBlank
    @NotNull
    private Long tel;
    @NotBlank
    @NotNull
    private String email;
}
