package edu.unialfa.thiago.rodrigues.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Float valor;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;
}
