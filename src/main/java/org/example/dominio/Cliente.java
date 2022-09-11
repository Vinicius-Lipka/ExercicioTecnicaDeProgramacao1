package org.example.dominio;


import lombok.Data;

@Data
public class Cliente {
    private Cliente cliente;
    private String nome;
    private String cpf;

}
