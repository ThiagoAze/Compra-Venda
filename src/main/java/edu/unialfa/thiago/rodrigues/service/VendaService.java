package edu.unialfa.thiago.rodrigues.service;

import edu.unialfa.thiago.rodrigues.model.ItemVenda;
import edu.unialfa.thiago.rodrigues.model.Venda;
import edu.unialfa.thiago.rodrigues.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public void vender(Venda venda){
        if (venda.getNome().isBlank() || venda.getItens().isEmpty()) return;

        // Referenciando cada item em venda antes de salvar
        for (ItemVenda item : venda.getItens()){
            item.setVenda(venda); // Para cada item, definimos o atributo venda
        }

        repository.save(venda);
    }

    public List<Venda> listarTodos() {
        return repository.findAll();
    }

    public Venda buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void remover(Long id){
        repository.deleteById(id);
    }
}
