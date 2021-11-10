package com.example.DB1.Persona.application.port;

import com.example.DB1.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface PersonaRepositorio extends JpaRepository<Persona, String> {

    List<Persona> findByusuario(String usuario);
    List<Persona> getData(HashMap<String, Object> conditions);
}

