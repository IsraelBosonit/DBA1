package com.example.DB1.Student.infrastructure.controller;

import com.example.DB1.Student.application.port.StudentRepositorio;
import com.example.DB1.Student.application.port.StudentService;
import com.example.DB1.Student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("student")
@RestController
public class DeleteStudentController {
    @Autowired
    StudentRepositorio studentRepositorio;
    @Autowired
    StudentService studentService;
    @DeleteMapping("/{id}")
    public void deleteStudentbyId(@PathVariable String id) throws Exception {
        Student s=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        studentService.comprobarAsignado(s);
        studentRepositorio.deleteById(id);
    }

}
