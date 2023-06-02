package com.autoxtreme.demo3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Venta {

    @Id
    @Column(name = "IdVentas")
    private int id;
    private int item;

    @Column(name = "IdCliente")
    private int idcliente;

    @Column(name = "IdEmpleado")
    private int idempleado;


    @Column(name = "IdCarro")
    private int idcarro;

    @Column(name = "NumeroSerie")
    private String Numserie;
    private String DescripcionC;

    @Column(name = "FechaVentas")
    private String fecha;

    @Column(name = "PrecioVenta")
    private double precio;

    @Column(name = "Cantidad")
    private int cantidad;
    private double subtotal;

    @Column(name = "Monto")
    private double monto;

}
