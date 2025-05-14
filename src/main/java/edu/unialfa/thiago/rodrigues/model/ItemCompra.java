package edu.unialfa.thiago.rodrigues.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Float valor;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

}
