package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Empleado;
import com.autoxtreme.demo3.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoController {
    @Autowired
    private IEmpleadoRepository repoEmple;

    @GetMapping("/empleado")
    public String cargarPagEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("lstEmpleado", repoEmple.findAll());
        return "crud-empleados";
    }
}
