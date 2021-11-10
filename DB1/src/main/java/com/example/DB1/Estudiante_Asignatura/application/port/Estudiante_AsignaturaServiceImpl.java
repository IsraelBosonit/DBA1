package com.example.DB1.Estudiante_Asignatura.application.port;

import com.example.DB1.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.example.DB1.Student.application.port.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Estudiante_AsignaturaServiceImpl implements Estudiante_AsignaturaService {
    @Autowired
    StudentService studentService;
    @Autowired
    Estudiante_AsignaturaRepositorio estudiante_asignaturaRepositorio;
    @Override
    public void ComprobarNulos(Estudiante_Asignatura a) throws Exception {
        if(a.getInitial_date()==null){
            throw new Exception("InitialDate no puede ser null");
        }
    }

    @Override
    public void ComprobarStudent(Estudiante_Asignatura a) throws Exception {
        studentService.FindStudentById(a.getStudent().getId_student());
    }

    @Override
    public Estudiante_Asignatura FindEstudiante_AsignaturaById(String id) throws Exception {
        Estudiante_Asignatura estudiante_asignatura=estudiante_asignaturaRepositorio.findById(id).orElseThrow(()->new Exception("estudiante_asignatura no existe"));
        return estudiante_asignatura;
    }
}
