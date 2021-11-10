package com.example.DB1.Student.infrastructure.controller;

import com.example.DB1.Auxiliar;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaRepositorio;
import com.example.DB1.Estudiante_Asignatura.application.port.Estudiante_AsignaturaService;
import com.example.DB1.Persona.application.port.PersonaRepositorio;
import com.example.DB1.Profesor.application.port.ProfesorRepositorio;
import com.example.DB1.Student.application.port.StudentRepositorio;
import com.example.DB1.Student.application.port.StudentService;
import com.example.DB1.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.example.DB1.Student.domain.Student;
import com.example.DB1.Student.infrastructure.controller.dto.input.StudentInputDTO;
import com.example.DB1.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("student")
@RestController
public class UpdateStudentController {
    @Autowired
    StudentRepositorio studentRepositorio;
    @Autowired
    StudentService studentService;
    @Autowired
    Estudiante_AsignaturaRepositorio estudiante_asignaturaRepositorio;
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Autowired
    Auxiliar auxiliar;
    @Autowired
    Estudiante_AsignaturaService estudiante_asignaturaService;

    @PutMapping("/{id}")
    public StudentOutputDTO modificarEstudiante(@PathVariable String id, @RequestBody StudentInputDTO s) throws Exception {
        Student student=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        if(s.getId_persona()!=null){
            student.setPersona(personaRepositorio.findById(s.getId_persona()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }
        if(s.getNum_hours_week()!=null){
            student.setNum_hours_week(s.getNum_hours_week());
        }
        if(s.getComents()!=null){
            student.setComents(s.getComents());
        }
        if(s.getId_profesor()!=null){
            student.setProfesor(profesorRepositorio.findById(s.getId_profesor()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }
        if(s.getBranch()!=null){
            student.setBranch(s.getBranch());
        }
        studentService.comprobarNulos(student);
        studentRepositorio.save(student);
        return auxiliar.CreateStudentOutputDTO(student);
    }
    @PutMapping("/asignar_asignaturas/{id}")
    public StudentOutputDTO añadirAsignaturas(@PathVariable String id, @RequestBody List<String> asignaturas) throws Exception {
        Student student=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        for(String s:asignaturas){
            Estudiante_Asignatura a=estudiante_asignaturaService.FindEstudiante_AsignaturaById(s);
            student.getAsignaturas().add(a);
            a.setStudent(student);
            estudiante_asignaturaRepositorio.save(a);
        }

        studentRepositorio.save(student);
        return auxiliar.CreateStudentOutputDTO(student);
    }

    @PutMapping("/desasignar_asignaturas/{id}")
    public StudentOutputDTO quitarAsignaturas(@PathVariable String id, @RequestBody List<String> asignaturas) throws Exception {
        Student student=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        for(String s:asignaturas){
            Estudiante_Asignatura a=estudiante_asignaturaService.FindEstudiante_AsignaturaById(s);
            student.getAsignaturas().remove(a);
            estudiante_asignaturaRepositorio.deleteById(a.getId_asignatura());
        }
        studentRepositorio.save(student);
        return auxiliar.CreateStudentOutputDTO(student);
    }

}
