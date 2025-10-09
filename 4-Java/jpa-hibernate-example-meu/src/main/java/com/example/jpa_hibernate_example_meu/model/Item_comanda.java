package com.example.jpa_hibernate_example_meu.model;


import javax.persistence.*;

@Entity
public class Item_comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item_comanda;

    @ManyToOne
    @JoinColumn(name = "id_comanda")
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "id_cardapio")
    private Cardapio cardapio;

    private int quantidade;

}
