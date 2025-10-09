package com.example.jpa_hibernate_example_meu.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cardapio;
    private String nome;
    private String descricao;

    public Cardapio(Long id_cardapio, String nome, String descricao) {
        this.id_cardapio = id_cardapio;
        this.nome = nome;
        this.descricao = descricao;

    }

    public Long getId_cardapio() {
        return id_cardapio;
    }

    public void setId_cardapio(Long id_cardapio) {
        this.id_cardapio = id_cardapio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
