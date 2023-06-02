package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Carro;
import com.autoxtreme.demo3.repository.ICarroRepository;
import com.autoxtreme.demo3.repository.IMarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarroController {
    @Autowired
    private ICarroRepository repoCar;

    @Autowired
    private IMarcaRepository repoMar;

    @GetMapping("/carro")
    public String cargarPagCarro(Model model){

        model.addAttribute("carro", new Carro());
        model.addAttribute("lstCarros", repoCar.findAll());
        return "crud-carros";
    }

}
