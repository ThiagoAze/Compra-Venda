package edu.unialfa.thiago.rodrigues.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(
        mappedBy = "compra", // Indica que o lado "dono" da relação está no atributo 'compra' da classe ItemCompra
        cascade = CascadeType.ALL, // Qualquer operação (save, delete, update) em Compra será propagada para seus itens
        orphanRemoval = true, // Remove do banco os itens que forem removidos da lista 'itens' da compra
        fetch = FetchType.EAGER // Sempre que uma compra for carregada, seus itens também serão carregados automaticamente
    )
    private List<ItemCompra> itens = new ArrayList<>(); //Inicializado lista para previnir problemas
}
