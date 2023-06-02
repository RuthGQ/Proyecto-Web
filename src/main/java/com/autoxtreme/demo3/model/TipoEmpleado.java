package com.autoxtreme.demo3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tipoempleado")
@Data
public class TipoEmpleado {
    @Id
    @Column(name = "IdTipo")
    private int idTipo;

    @Column(name = "Descripcion")
    private String descrip;

    @OneToMany(mappedBy = "objTipo")
    @JsonIgnore
    Set<Empleado> empleado;
}
