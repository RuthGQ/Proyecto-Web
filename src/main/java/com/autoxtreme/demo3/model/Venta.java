package com.autoxtreme.demo3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "tb_ventas")
@Data
public class Venta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ventas")
    private int idVentas;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente objCliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado objEmpleado;

    @Column(name = "NumeroSerie")
    private String numeroSerie;

    @Column(name = "FechaVentas")
    private Date fechaVentas;

    @Column(name = "Monto")
    private double monto;
    
    
}
