package edu.unialfa.thiago.rodrigues.controller;

import edu.unialfa.thiago.rodrigues.model.ItemVenda;
import edu.unialfa.thiago.rodrigues.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemVendaController {

    @Autowired
    private ItemVendaService service;

    @GetMapping("itemVender")
    public String abrirFormulario(ItemVenda item, Model model){
        model.addAttribute("itemVendas", service.listarTodos());
        return "itemVenda/form";
    }

    @GetMapping("/itemVenda")
    public String iniciar(Model model){
        var itemVenda = service.listarTodos();
        model.addAttribute("listaDeItensVendas", itemVenda);
        return "itemVenda/lista";
    }

    @PostMapping("salvarItemVenda")
    public String salvarItemVenda(ItemVenda itemVenda, Model model){
        service.salvar(itemVenda);
        return "redirect:/itemVenda";
    }

    @GetMapping("alterarItemVenda/{id}")
    public String alterarItemVenda(@PathVariable Long id, Model model){
        model.addAttribute("itemVenda", service.buscarPorId(id));
        return "itemVenda/form";
    }

    @GetMapping("removerItemVenda/{id}")
    public String removerItemVenda(@PathVariable Long id, Model model){
        service.remover(id);
        return "redirect:/itemVenda";
    }
}
