package com.example.examenfinal_20210751.Respository;

import com.example.examenfinal_20210751.Entity.Distribuidora;
import com.example.examenfinal_20210751.Entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais,Integer> {
    Pais findByNombre(String nombre);

}
