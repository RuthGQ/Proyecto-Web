package com.autoxtreme.demo3.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tb_empleado")
@Data
public class Empleado {
    @Id
    @Column(name = "id_empleado")
    private Integer IdEmpleado;

    @Column(name = "Dni")
    private String dni;

    @Column(name = "Nombres")
    private String nom;

    @Column(name = "Apellidos")
    private String ape;

    @Column(name = "Telefono")
    private String tel;

    @Column(name = "User")
    private String user;

    @Column(name = "Clave")
    private String clave;

    @Column(name = "ImgEmpleado")
    private String img;

    @ManyToOne()
    @JoinColumn(name = "idtipo")
    TipoEmpleado objTipo;
}
