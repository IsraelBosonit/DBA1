package com.example.DB1.Estudiante_Asignatura.infrastructure.controller;

import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaRepositorio;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaService;
import com.example.DB1.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("estudiante_asignatura")
@RestController
public class DeleteEstudiante_AsignaturaController {
    @Autowired
    Estudiante_AsignaturaRepositorio estudiante_asignaturaRepositorio;
    @Autowired
    Estudiante_AsignaturaService estudiante_asignaturaService;
    @DeleteMapping("/{id}")
    public void deleteEstudiante_AsignaturabyId(@PathVariable String id) throws Exception {
        Estudiante_Asignatura a=estudiante_asignaturaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        estudiante_asignaturaRepositorio.deleteById(id);
    }
}
