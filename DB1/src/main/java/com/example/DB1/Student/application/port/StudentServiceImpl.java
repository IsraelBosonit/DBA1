package com.example.DB1.Student.application.port;

import com.example.DB1.Student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepositorio studentRepositorio;
    @Override
    public void comprobarNulos(Student s) throws Exception{
        if(s.getNum_hours_week()==null){
            throw new Exception("Num_hours_week no puede ser nulo");
        }
        if(s.getBranch()==null){
            throw new Exception("Branch no puede ser nulo");
        }
    }

    @Override
    public void comprobarAsignado(Student s) throws Exception {
        if(!(s.getAsignaturas().isEmpty())){
            throw new Exception("Student tiene asignaturas asignadas");
        }
    }

    @Override
    public Student FindStudentById(String id) throws Exception {
        Student student=studentRepositorio.findById(id).orElseThrow(()->new Exception("El estudiante no existe"));
        return student;
    }
}
