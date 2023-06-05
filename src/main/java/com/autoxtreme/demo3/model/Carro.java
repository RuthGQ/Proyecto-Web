package com.autoxtreme.demo3.model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_carro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

		@Id
		@Column (name = "id_Carro") //este nombre debe ser estar escrito así
	    private int IdCarro;

	    @Column (name = "Descripcion", length = 45)
	    private String descripcion;

	    @Column(name = "Origen")
	    private String origen;

	    @Column(name = "Combustible")
	    private String combustible;

	    @Column(name = "Precio")
	    private double precio;

	    @Column(name = "Stock")
	    private int stock;
	    
	    @Column(name = "id_marca")
	    private int IdMarca;
	    
		@ManyToOne
		@JoinColumn(name = "id_marca", insertable = false, updatable = false)
		private Marca objMarca;

}
