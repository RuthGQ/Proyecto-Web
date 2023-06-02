package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Cliente;
import com.autoxtreme.demo3.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
    @Autowired
    private IClienteRepository repoCli;

    @GetMapping("/cliente")
    public String cargarPagCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("lstCliente", repoCli.findAll());
        return "crud-clientes";
    }
}
