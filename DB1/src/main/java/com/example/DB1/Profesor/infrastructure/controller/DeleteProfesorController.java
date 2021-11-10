package com.example.DB1.Profesor.infrastructure.controller;

import com.example.DB1.Profesor.application.port.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RequestMapping("profesor")
@RestController
public class DeleteProfesorController {
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @DeleteMapping("/{id}")
    public void DeleteProfesorbyId(@PathVariable String id){
        profesorRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        profesorRepositorio.deleteById(id);

    }
}
