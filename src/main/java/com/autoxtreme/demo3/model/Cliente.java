package com.autoxtreme.demo3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    @Id
    @Column(name = "IdCliente")
    private int idCli ;

    @Column(name = "Dni")
    private String dni;

    @Column(name = "Nombres")
    private String nom;

    @Column(name = "Apellidos")
    private String ape;

    @Column(name = "Direccion")
    private String dir;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Telefono")
    private int tel;
}
