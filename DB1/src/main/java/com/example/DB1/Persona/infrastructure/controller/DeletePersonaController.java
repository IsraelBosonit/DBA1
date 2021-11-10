package com.example.DB1.Persona.infrastructure.controller;

import com.example.DB1.Persona.application.port.PersonaRepositorio;
import com.example.DB1.Persona.application.port.PersonaService;
import com.example.DB1.Persona.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("persona")
@RestController
public class DeletePersonaController {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;
    @DeleteMapping("/{id}")
    public void deletePersonabyId(@PathVariable String id)throws Exception{
        Persona p=personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        personaService.ComprobarAsignado(p);
        personaRepositorio.deleteById(id);
    }
}
