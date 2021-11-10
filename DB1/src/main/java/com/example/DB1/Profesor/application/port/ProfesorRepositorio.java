package com.example.DB1.Profesor.application.port;

import com.example.DB1.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepositorio extends JpaRepository<Profesor,String> {

}
