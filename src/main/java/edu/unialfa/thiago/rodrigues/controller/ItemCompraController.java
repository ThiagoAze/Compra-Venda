package edu.unialfa.thiago.rodrigues.controller;

import edu.unialfa.thiago.rodrigues.model.ItemCompra;
import edu.unialfa.thiago.rodrigues.service.ItemCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemCompraController {

    @Autowired
    private ItemCompraService service;

    @GetMapping("itemComprar")
    public String abrirFormulario(ItemCompra item, Model model) {
        model.addAttribute("itemCompras", service.listarTodos());
        return "itemCompra/form";
    }

    @GetMapping("/itemCompra")
    public String iniciar(Model model){
        var itemCompra = service.listarTodos();
        model.addAttribute("listaDeItensCompras", itemCompra);
        return "itemCompra/lista";
    }

    @PostMapping("salvarItemCompra")
    public String salvarItemCompra(ItemCompra itemCompra, Model model){
        service.salvar(itemCompra);
        return "redirect:/itemCompra";
    }

    @GetMapping("alterarItemCompra/{id}")
    public String alterarItemCompra(@PathVariable Long id, Model model) {
        model.addAttribute("itemCompra", service.buscarPorId(id));
        return "itemCompra/form";
    }

    @GetMapping("removerItemCompra/{id}")
    public String removerItemCompra(@PathVariable Long id, Model model) {
        service.remover(id);
        return "redirect:/itemCompra";
    }
}
