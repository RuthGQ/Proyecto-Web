package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Empleado;
import com.autoxtreme.demo3.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    private IEmpleadoRepository emRep;

    // crear un controlador para cargar la pagina index
    @GetMapping("/cargar")
    public String cargarPag(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "index";
    }

    @PostMapping("/validar")
    public String grabarPag(@ModelAttribute Empleado empleado, Model model) {
        System.out.println(empleado);
        Empleado e = emRep.findByUserAndClave(empleado.getUser(), empleado.getClave());
        System.out.println(e);
        if (e == null) {
            model.addAttribute("empleado", new Empleado());
            model.addAttribute("mensaje", "Usuario o clave incorrecto");
            return "index";
        } else {
            model.addAttribute("empleado", e);
            return "menu-principal";
        }
    }
}
