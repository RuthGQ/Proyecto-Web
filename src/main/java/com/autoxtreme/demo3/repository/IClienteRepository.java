package com.autoxtreme.demo3.repository;

import com.autoxtreme.demo3.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByDni(String dni);
}
