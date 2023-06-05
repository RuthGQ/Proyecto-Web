package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Venta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReporteController {

    @GetMapping("/reporte/ventas")
    public String cargarPagReporteVenta(Model model){
        model.addAttribute("venta", new Venta());
        return "reporte-ventas";
    }
}
