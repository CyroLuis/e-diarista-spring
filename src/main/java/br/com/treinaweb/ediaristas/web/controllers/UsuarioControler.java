package br.com.treinaweb.ediaristas.web.controllers;

import br.com.treinaweb.ediaristas.web.services.WebUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioControler {

    @Autowired
    private WebUsuarioService service;
    
    @GetMapping
    public ModelAndView buscarTodos(){
        var modelAndView = new ModelAndView("/admin/usuarios/lista");
        
        modelAndView.addObject("usuarios",service.buscarTodos());
        return modelAndView;
    }
}
