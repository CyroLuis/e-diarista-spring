package br.com.treinaweb.ediaristas.web.controllers;
import br.com.treinaweb.ediaristas.core.enums.Icone;
import br.com.treinaweb.ediaristas.core.models.Servico;
import br.com.treinaweb.ediaristas.web.dtos.FlashMessage;
import br.com.treinaweb.ediaristas.web.dtos.ServicoForm;
import br.com.treinaweb.ediaristas.web.services.WebServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/servico")
public class ServicoController {

    @Autowired
    private WebServicoService service;

    @GetMapping("lista")
    public ModelAndView buscarTodos(){
        var modelAnView = new ModelAndView("admin/servico/lista");

        modelAnView.addObject("servicos",service.buscarTodos());

        return modelAnView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        var modelAndview = new ModelAndView("admin/servico/form");
        modelAndview.addObject("form", new Servico());
        return modelAndview;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("form") ServicoForm form, BindingResult result, RedirectAttributes attrs){

        if (result.hasErrors()){
            return "admin/servico/form";
        }

       service.cadastrar(form);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success","Serviço cadastrado com sucesso"));

        return "redirect:/admin/servico/lista";

    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id){
        var modelAndView = new ModelAndView("/admin/servico/form");

        modelAndView.addObject("form",service.buscarPorId(id));

        return modelAndView;

    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id,@Valid @ModelAttribute("form") ServicoForm form, BindingResult result, RedirectAttributes attrs){

        if (result.hasErrors()){
            return "admin/servico/form";
        }

        service.editar(form,id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success","Serviço editado com sucesso"));
        return "redirect:/admin/servico/lista";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id){
        service.excluirPorId(id);

        return "redirect:/admin/servico/lista";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones(){
            return Icone.values();
    }

}
