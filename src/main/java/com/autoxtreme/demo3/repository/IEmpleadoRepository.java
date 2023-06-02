package com.autoxtreme.demo3.repository;

import com.autoxtreme.demo3.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Empleado findByUserAndClave(String user, String clave);
}
