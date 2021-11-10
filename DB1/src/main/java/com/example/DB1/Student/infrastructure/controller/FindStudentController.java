package com.example.DB1.Student.infrastructure.controller;

import com.example.DB1.Auxiliar;
import com.example.DB1.Student.application.port.StudentRepositorio;
import com.example.DB1.Student.application.port.StudentService;
import com.example.DB1.Student.domain.Student;
import com.example.DB1.Student.infrastructure.controller.dto.output.StudentFullOutputDTO;
import com.example.DB1.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("student")
@RestController
public class FindStudentController {

    @Autowired
    StudentRepositorio studentRepositorio;
    @Autowired
    StudentService studentService;
    @Autowired
    Auxiliar auxiliar;
    @GetMapping("/{id}")

    public StudentOutputDTO getStudentbyId(@PathVariable String id, @RequestParam(name="outputType", defaultValue = "simple") String outputType){
        Student s=studentRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        StudentOutputDTO out = null;
        if(outputType.equals("simple")){
            out=auxiliar.CreateStudentOutputDTO(s);
        }
        if(outputType.equals("full")){
            out=new StudentFullOutputDTO(s);
        }
        return out;
    }
    @GetMapping
    public List<StudentOutputDTO> getAll(){
        List<Student> l=studentRepositorio.findAll();
        List<StudentOutputDTO> lout=new ArrayList<>();
        for (Student s : l) {
            lout.add(auxiliar.CreateStudentOutputDTO(s));
        }
        return lout;
    }
}
