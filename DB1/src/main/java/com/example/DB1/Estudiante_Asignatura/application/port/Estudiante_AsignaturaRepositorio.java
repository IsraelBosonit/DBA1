package com.example.DB1.Estudiante_Asignatura.application.port;

import com.example.DB1.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Estudiante_AsignaturaRepositorio extends JpaRepository<Estudiante_Asignatura,String> {
    Estudiante_Asignatura findByasignatura(String asignatura);

}
