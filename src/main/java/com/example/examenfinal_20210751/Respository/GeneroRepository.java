package com.example.examenfinal_20210751.Respository;

import com.example.examenfinal_20210751.Entity.Distribuidora;
import com.example.examenfinal_20210751.Entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero,Integer> {

    Genero findByNombre(String nombre);

}
