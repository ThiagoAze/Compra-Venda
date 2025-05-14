package edu.unialfa.thiago.rodrigues.service;

import edu.unialfa.thiago.rodrigues.model.ItemVenda;
import edu.unialfa.thiago.rodrigues.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository ItemVendaRepository;

    public void salvar(ItemVenda itemVenda){
        if (itemVenda.getDescricao().isBlank() || itemVenda.getValor().isNaN()) return;
        ItemVendaRepository.save(itemVenda);
    }

    public List<ItemVenda> listarTodos() {
        return ItemVendaRepository.findAll();
    }

    public ItemVenda buscarPorId(Long id) {
        return ItemVendaRepository.findById(id).get();
    }

    public void remover(Long id){
        ItemVendaRepository.deleteById(id);
    }
}
