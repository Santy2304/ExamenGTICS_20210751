package com.example.examenfinal_20210751.Respository;

import com.example.examenfinal_20210751.Entity.Distribuidora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistribuidoraRepository extends JpaRepository<Distribuidora,Integer> {

    Distribuidora findByNombre(String nombre);
}
