package com.example.examenfinal_20210751.Respository;

import com.example.examenfinal_20210751.Entity.Distribuidora;
import com.example.examenfinal_20210751.Entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlataformaRepository extends JpaRepository<Plataforma,Integer> {


    Plataforma findByNombre(String nombre);

}
