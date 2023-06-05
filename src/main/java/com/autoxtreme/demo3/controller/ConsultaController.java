package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Carro;
import com.autoxtreme.demo3.model.Cliente;
import com.autoxtreme.demo3.model.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultaController {
    @GetMapping("/consultas/carros")
    public String cargarPagConsultaCarro(Model model){
        model.addAttribute("carro", new Carro());
        return "consulta-carros";
    }

    @GetMapping("/consultas/empleados")
    public String cargarPagConsultaEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "consulta-empleados";
    }

    @GetMapping("/consultas/clientes")
    public String cargarPagConsultaCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "consulta-clientes";
    }
}
