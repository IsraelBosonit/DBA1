package com.example.DB1.Profesor.infrastructure.controller;

import com.example.DB1.Persona.application.port.PersonaRepositorio;
import com.example.DB1.Profesor.application.port.ProfesorRepositorio;
import com.example.DB1.Profesor.application.port.ProfesorService;
import com.example.DB1.Profesor.domain.Profesor;
import com.example.DB1.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.DB1.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("profesor")
@RestController
public class UpdateProfesorController {
    @Autowired
    ProfesorService profesorService;
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Autowired
    PersonaRepositorio personaRepositorio;
    @PutMapping("/{id}")
    public ProfesorOutputDTO modificarProfesor(@PathVariable String id, @RequestBody ProfesorInputDTO p) throws Exception {
        Profesor profesor=profesorRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        if(p.getId_persona()!=null){
            profesor.setPersona(personaRepositorio.findById(p.getId_persona()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }
        if(p.getComents()!=null){
            profesor.setComents(p.getComents());
        }
        if(p.getBranch()!=null){
            profesor.setBranch(p.getBranch());
        }
        profesorService.ComprobarNulos(profesor);
        profesorRepositorio.save(profesor);
        return new ProfesorOutputDTO(profesor);
    }
}
