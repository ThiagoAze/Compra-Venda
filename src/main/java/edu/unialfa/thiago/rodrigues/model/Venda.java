package edu.unialfa.thiago.rodrigues.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(
        mappedBy = "venda", // Indica que o lado "dono" da relação está no atributo 'venda' da classe ItemVenda
        cascade = CascadeType.ALL, // Qualquer operação (save, delete, update) em Venda será propagada para seus itens
        orphanRemoval = true, // Remove do banco os itens que forem removidos da lista 'itens' da venda
        fetch = FetchType.EAGER // Sempre que uma venda for carregada, seus itens também serão carregados automaticamente
    )
    private List<ItemVenda> itens = new ArrayList<>(); //Inicializado lista para previnir problemas
}
