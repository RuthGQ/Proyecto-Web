package com.autoxtreme.demo3.repository;

import com.autoxtreme.demo3.model.Venta;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {
	List<Venta> findByFechaVentasBetween(Date fechaInicio, Date fechaFin);
}
