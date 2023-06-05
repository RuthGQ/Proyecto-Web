package com.autoxtreme.demo3.repository;

import com.autoxtreme.demo3.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarroRepository extends JpaRepository<Carro, Integer> {
}