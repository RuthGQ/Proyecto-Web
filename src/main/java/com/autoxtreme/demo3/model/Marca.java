package com.autoxtreme.demo3.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "tb_marca")

public class Marca {
	
	@Id
	@Column (name = "id_marca") //este nombre debe ser estar escrito así
	private int IdMarca;
	
	@Column (name = "Descripcion", length = 45) 
	private String descripcion;
	
	@OneToMany(mappedBy = "objMarca")
	@JsonIgnore
	Set<Carro> carro;
	
}