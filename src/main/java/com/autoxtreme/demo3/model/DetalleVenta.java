package com.autoxtreme.demo3.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_detalle_ventas")
@Data

public class DetalleVenta {
    @Id
    @Column(name = "id_detalle_ventas")
    private int idDetalleVentas;

    @ManyToOne
    @JoinColumn(name = "id_ventas")
    private Venta objVentas;

    @ManyToOne
    @JoinColumn(name = "id_carro")
    private Carro objCarro;

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "PrecioVenta")
    private double precioVenta;
    
    
}
