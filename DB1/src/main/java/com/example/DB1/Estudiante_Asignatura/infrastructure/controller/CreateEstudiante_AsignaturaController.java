package com.example.DB1.Estudiante_Asignatura.infrastructure.controller;

import com.example.DB1.Auxiliar;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaRepositorio;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaService;
import com.example.DB1.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.input.Estudiante_AsignaturaInputDTO;
import com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.output.Estudiante_AsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("estudiante_asignatura")
@RestController
public class CreateEstudiante_AsignaturaController {
    @Autowired
    Estudiante_AsignaturaService estudiante_asignaturaService;
    @Autowired
    Estudiante_AsignaturaRepositorio estudiante_asignaturaRepositorio;
    @Autowired
    Auxiliar auxiliar;
    @PostMapping
    public Estudiante_AsignaturaOutputDTO añadirEstudiante_Asignatura(@RequestBody Estudiante_AsignaturaInputDTO a) throws Exception {
        Estudiante_Asignatura est=auxiliar.CreateEstudiante_Asignatura(a);
        estudiante_asignaturaService.ComprobarNulos(est);
        estudiante_asignaturaService.ComprobarStudent(est);
        estudiante_asignaturaRepositorio.save(est);
        return auxiliar.CreateEstudiante_AsignaturaOutputDTO(est);
    }
}
