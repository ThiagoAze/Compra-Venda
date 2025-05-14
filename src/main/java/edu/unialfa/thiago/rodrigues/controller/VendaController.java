package edu.unialfa.thiago.rodrigues.controller;

import edu.unialfa.thiago.rodrigues.model.Venda;
import edu.unialfa.thiago.rodrigues.service.VendaService;
import edu.unialfa.thiago.rodrigues.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendaController {

    @Autowired
    private VendaService service;

    @Autowired
    private ItemVendaService itemVendaService;

    @GetMapping("vender")
    public String abrirFormulario(Venda venda, Model model) {
        model.addAttribute("venda", venda);
        model.addAttribute("itemVendas", itemVendaService.listarTodos());
        return "venda/form";
    }

    @GetMapping("/venda")
    public String iniciar(Model model){
        var vender = service.listarTodos();
        model.addAttribute("listaDeVendas", vender);
        return "venda/lista";
    }

    @PostMapping("salvarVenda")
    private String salvarVenda(Venda venda, Model model){
        service.vender(venda);
        return "redirect:/venda";
    }

    @GetMapping("alterarVenda/{id}")
    public String alterarVenda(@PathVariable Long id, Model model) {
        model.addAttribute("itemVendas", itemVendaService.listarTodos());
        model.addAttribute("venda", service.buscarPorId(id));
        return "venda/form";
    }

    @GetMapping("removerVenda/{id}")
    public String removerVenda(@PathVariable Long id, Model model) {
        service.remover(id);
        return "redirect:/venda";
    }
}
