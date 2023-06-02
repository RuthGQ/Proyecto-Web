package com.autoxtreme.demo3.controller;

import com.autoxtreme.demo3.model.Carro;
import com.autoxtreme.demo3.model.Cliente;
import com.autoxtreme.demo3.model.Venta;
import com.autoxtreme.demo3.repository.ICarroRepository;
import com.autoxtreme.demo3.repository.IClienteRepository;
import com.autoxtreme.demo3.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class VentaController {

    @Autowired
    private IVentaRepository repoVen;

    @Autowired
    private IClienteRepository repoCli;

    @Autowired
    private ICarroRepository repoCar;

    Cliente clienteG = new Cliente();
    Venta ventaG = new Venta();

    Carro carroG = new Carro();

    @GetMapping("/registro/venta")
    public String cargarPagRegistroVenta(Model model){
        model.addAttribute("cliente", clienteG);
        model.addAttribute("venta",ventaG);
        model.addAttribute("carro",carroG);
        return "registro-ventas";
    }

    @GetMapping("/busquedacliente")
    public String cargarBusquedaCliente(@RequestParam(name = "dni") String dni, Model model) {

        System.out.println(dni);
        Cliente cliente = repoCli.findByDni(dni);
        System.out.println(cliente.getNom());
        clienteG = cliente;
        model.addAttribute("cliente", clienteG);
        model.addAttribute("venta",ventaG);
        model.addAttribute("carro",carroG);
        return "registro-ventas";
    }


    @GetMapping("/busquedacarro")
    public String cargarBusquedaCarro(@RequestParam(name = "carro") String carro, Model model) {

        Carro carroObtenido = repoCar.findById(Integer.parseInt(carro)).orElse(null);
        assert carroObtenido != null;
        System.out.println(carroObtenido.getId());
        carroG = carroObtenido;
        model.addAttribute("cliente", clienteG);
        model.addAttribute("venta",ventaG);
        model.addAttribute("carro",carroG);
        return "registro-ventas";
    }


}
