package com.example.examenfinal_20210751.Respository;

import com.example.examenfinal_20210751.Entity.Distribuidora;
import com.example.examenfinal_20210751.Entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora,Integer> {
    Editora findByNombre(String nombre);

}
