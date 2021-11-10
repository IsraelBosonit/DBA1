package com.example.DB1.Profesor.infrastructure.controller;

import com.example.DB1.Profesor.application.port.ProfesorRepositorio;
import com.example.DB1.Profesor.application.port.ProfesorService;
import com.example.DB1.Profesor.domain.Profesor;
import com.example.DB1.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("profesor")
@RestController
public class FindProfesorController {
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Autowired
    ProfesorService profesorService;
    @GetMapping("/{id}")
    public ProfesorOutputDTO getProfesorbyId(@PathVariable String id){
        Profesor p=profesorRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        ProfesorOutputDTO out=new ProfesorOutputDTO(p);
        return out;
    }
    @GetMapping
    public List<ProfesorOutputDTO> getAll(){
        List<Profesor> l=profesorRepositorio.findAll();
        List<ProfesorOutputDTO> lout=new ArrayList<>();
        for(Profesor p:l){
            lout.add(new ProfesorOutputDTO(p));
        }
        return lout;
    }
}
