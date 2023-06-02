package com.autoxtreme.demo3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "marca")
@Data
public class Marca {
    @Id
    @Column(name = "IdMarca")
    private int idmarca;

    @Column(name = "Descripcion")
    private String descripcion;

}
