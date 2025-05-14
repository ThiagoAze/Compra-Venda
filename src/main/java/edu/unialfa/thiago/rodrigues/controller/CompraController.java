package edu.unialfa.thiago.rodrigues.controller;

import edu.unialfa.thiago.rodrigues.model.Compra;
import edu.unialfa.thiago.rodrigues.model.ItemCompra;
import edu.unialfa.thiago.rodrigues.service.CompraService;
import edu.unialfa.thiago.rodrigues.service.ItemCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompraController {

    @Autowired
    private CompraService service;

    @Autowired
    private ItemCompraService itemCompraService;

    @GetMapping("comprar")
    public String abrirFormulario(Compra compra, Model model) {
        model.addAttribute("compra", compra);

        // Filtra apenas os itens que ainda não têm compra associada
        List<ItemCompra> disponiveis = itemCompraService.listarTodos()
            .stream() // Converte a lista em um Stream (para aplicar filtros)
            .filter(item -> item.getCompra() == null) // Mantém apenas os itens que não estão vinculados a nenhuma compra
            .toList(); // Coleta os itens filtrados de volta em uma lista

        // model.addAttribute("itemCompras", itemCompraService.listarTodos());
        model.addAttribute("itemCompras", disponiveis);
        return "compra/form";
    }

    @GetMapping("/compra")
    public String iniciar(Model model){
        var compra = service.listarTodos();
        model.addAttribute("listaDeCompras", compra);
        return "compra/lista";
    }

    @PostMapping("salvarCompra")
    public String salvarCompra(Compra compra, Model model){
        service.comprar(compra);
        return "redirect:/compra";
    }

    @GetMapping("alterarCompra/{id}")
    public String alterarCompra(@PathVariable Long id, Model model) {
        model.addAttribute("itemCompras", itemCompraService.listarTodos());
        model.addAttribute("compra", service.buscarPorId(id));
        return "compra/form";
    }

    @GetMapping("removerCompra/{id}")
    public String removerCompra(@PathVariable Long id, Model model) {
        service.remover(id);
        return "redirect:/compra";
    }
}
