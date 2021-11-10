package com.example.DB1.Estudiante_Asignatura.infrastructure.controller;

import com.example.DB1.Auxiliar;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaRepositorio;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaService;
import com.example.DB1.Student.application.port.StudentService;
import com.example.DB1.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.input.Estudiante_AsignaturaInputDTO;
import com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.output.Estudiante_AsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("estudiante_asignatura")
@RestController
public class UpdateEstudiante_AsignaturaController {
    @Autowired
    Estudiante_AsignaturaRepositorio estudiante_asignaturaRepositorio;
    @Autowired
    Estudiante_AsignaturaService estudiante_asignaturaService;
    @Autowired
    StudentService studentService;
    @Autowired
    Auxiliar auxiliar;
    @PutMapping("/{id}")
    public Estudiante_AsignaturaOutputDTO modificarEstudiante_Asignatura(@PathVariable String id, @RequestBody Estudiante_AsignaturaInputDTO a) throws Exception {
        Estudiante_Asignatura est=estudiante_asignaturaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        if(a.getId_student()!=null){
            est.setStudent(studentService.FindStudentById(a.getId_student()));
        }
        if(a.getAsignatura()!=null){
            est.setAsignatura(a.getAsignatura());
        }
        if(a.getComents()!=null){
            est.setComents(a.getComents());
        }
        if(a.getInitial_date()!=null){
            est.setInitial_date(a.getInitial_date());
        }
        if(a.getFinish_date()!=null){
            est.setFinish_date(a.getFinish_date());
        }
        estudiante_asignaturaService.ComprobarNulos(est);
        estudiante_asignaturaRepositorio.save(est);
        return auxiliar.CreateEstudiante_AsignaturaOutputDTO(est);
    }
}
