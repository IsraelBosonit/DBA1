package com.example.DB1.Estudiante_Asignatura.infrastructure.controller;

import com.example.DB1.Auxiliar;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaRepositorio;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaService;
import com.example.DB1.Student.application.port.StudentRepositorio;
import com.example.DB1.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.example.DB1.Student.domain.Student;
import com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.output.Estudiante_AsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("estudiante_asignatura")
@RestController
public class FindEstudiante_AsignaturaController {
    @Autowired
    Estudiante_AsignaturaService estudiante_asignaturaService;
    @Autowired
    Estudiante_AsignaturaRepositorio estudiante_asignaturaRepositorio;
    @Autowired
    StudentRepositorio studentRepositorio;
    @Autowired
    Auxiliar auxiliar;
    @GetMapping("/{id}")
    public Estudiante_AsignaturaOutputDTO findEstudiante_AsignaturabyId(@PathVariable String id){
        Estudiante_Asignatura est=estudiante_asignaturaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return auxiliar.CreateEstudiante_AsignaturaOutputDTO(est);

    }
    @GetMapping
    public List<Estudiante_AsignaturaOutputDTO> getAll(){
        List<Estudiante_Asignatura> l=estudiante_asignaturaRepositorio.findAll();
        List<Estudiante_AsignaturaOutputDTO> lout=new ArrayList<>();
        for(Estudiante_Asignatura a:l){
            lout.add(auxiliar.CreateEstudiante_AsignaturaOutputDTO(a));
        }
        return lout;
    }
    @GetMapping("/estudiante/{id}")
    public List<Estudiante_AsignaturaOutputDTO> findEstudiante_AsignaturabyStudent(@PathVariable String id){
        Student s=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Estudiante_Asignatura> l=s.getAsignaturas();
        List<Estudiante_AsignaturaOutputDTO> lout=new ArrayList<>();
        for(Estudiante_Asignatura a:l){
            lout.add(auxiliar.CreateEstudiante_AsignaturaOutputDTO(a));
        }
        return lout;
    }
}
