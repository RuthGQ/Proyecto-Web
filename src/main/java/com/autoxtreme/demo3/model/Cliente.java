package com.autoxtreme.demo3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data

public class Cliente {
    @Id
    @Column(name = "id_cliente")
    private int id_cliente ;

    @Column(name = "dni")
    private String dni;

    @Column(name = "Nombres")
    private String nom;

    @Column(name = "Apellidos")
    private String ape;

    @Column(name = "Direccion")
    private String dir;

    @Column(name = "Correo")
    private String corre;

    @Column(name = "Telefono")
    private int tel;
 
}


