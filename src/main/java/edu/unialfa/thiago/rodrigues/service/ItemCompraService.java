package edu.unialfa.thiago.rodrigues.service;

import edu.unialfa.thiago.rodrigues.model.ItemCompra;
import edu.unialfa.thiago.rodrigues.repository.ItemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCompraService {

    @Autowired
    private ItemCompraRepository itemCompraRepository;

    public void salvar(ItemCompra itemCompra){
        if (itemCompra.getDescricao().isBlank() || itemCompra.getValor().isNaN()) return;
        itemCompraRepository.save(itemCompra);
    }

    public List<ItemCompra> listarTodos() {
        return itemCompraRepository.findAll();
    }

    public ItemCompra buscarPorId(Long id) {
        return itemCompraRepository.findById(id).get();
    }

    public void remover(Long id){
        itemCompraRepository.deleteById(id);
    }
}
