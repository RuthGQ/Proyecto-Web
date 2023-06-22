package com.autoxtreme.demo3.repository;

import com.autoxtreme.demo3.model.DetalleVenta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {

    List<DetalleVenta> findByObjVentasIdVentas(int idVentas);
}
