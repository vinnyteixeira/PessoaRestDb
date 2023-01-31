package com.atividade.pessoa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Nome;
    private Long cpf;
    private Long rg;
    private LocalDateTime dataNasc;
    @Enumerated(EnumType.STRING)
    private estadoCiv estadoCiv;
    private Long tel;
    private String email;
}
