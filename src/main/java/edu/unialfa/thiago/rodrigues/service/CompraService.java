package edu.unialfa.thiago.rodrigues.service;

import edu.unialfa.thiago.rodrigues.model.Compra;
import edu.unialfa.thiago.rodrigues.model.ItemCompra;
import edu.unialfa.thiago.rodrigues.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public void comprar(Compra compra){
        if (compra.getNome().isBlank() || compra.getItens().isEmpty()) return;

        // Referenciando cada item em compra antes de salvar
        for (ItemCompra item : compra.getItens()){
            item.setCompra(compra); // Para cada item, definimos o atributo compra
        }

        repository.save(compra);
    }

    public List<Compra> listarTodos() {
        return repository.findAll();
    }

    public Compra buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void remover(Long id){
        repository.deleteById(id);
    }
}
