package com.autoxtreme.demo3.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "carro")
@Data
public class Carro {
    @Id
    @Column(name = "IdCarro")
    private int id;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Origen")
    private String origen;

    @Column(name = "Combustible")
    private String Combustible;

    @Column(name = "Precio")
    private double precio;

    @Column(name = "Stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "idmarca")
    Marca objMarca;



}
