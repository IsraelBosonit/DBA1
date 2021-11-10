package com.example.DB1;

import com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.output.Estudiante_AsignaturaOutputDTO;
import com.example.DB1.Persona.application.port.PersonaService;
import com.example.DB1.Persona.infrastructure.controller.dto.output.PersonaOutputEstudianteDTO;
import com.example.DB1.Persona.infrastructure.controller.dto.output.PersonaOutputProfesorDTO;
import com.example.DB1.Profesor.application.port.ProfesorService;
import com.example.DB1.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.example.DB1.Persona.domain.Persona;
import com.example.DB1.Profesor.domain.Profesor;
import com.example.DB1.Student.application.port.StudentService;
import com.example.DB1.Student.domain.Student;
import com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.input.Estudiante_AsignaturaInputDTO;
import com.example.DB1.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.example.DB1.Student.infrastructure.controller.dto.input.StudentInputDTO;
import com.example.DB1.Student.infrastructure.controller.dto.output.StudentOutputAsignaturaDTO;
import com.example.DB1.Student.infrastructure.controller.dto.output.StudentOutputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
public class Auxiliar {
    @Autowired
    PersonaService personaService;
    @Autowired
    ProfesorService profesorService;
    @Autowired
    StudentService studentService;

    public Student CreateStudent(StudentInputDTO s) throws Exception {
        Student student = new Student();
        personaService.EsProfesor(personaService.FindPersonaById(s.getId_persona()));
        student.setPersona(personaService.FindPersonaById(s.getId_persona()));
        student.setNum_hours_week(s.getNum_hours_week());
        student.setProfesor(profesorService.FindProfesorById(s.getId_profesor()));
        student.setComents(s.getComents());
        student.setBranch(s.getBranch());
        return student;
    }
    public Profesor CreateProfesor(ProfesorInputDTO p) throws Exception {
        Profesor profesor = new Profesor();
        personaService.EsEstudiante(personaService.FindPersonaById(p.getId_persona()));
        profesor.setPersona(personaService.FindPersonaById(p.getId_persona()));
        profesor.setComents(p.getComents());
        profesor.setBranch(p.getBranch());
        return profesor;
    }
    public Estudiante_Asignatura CreateEstudiante_Asignatura(Estudiante_AsignaturaInputDTO a) throws Exception {
        Estudiante_Asignatura estudiante_asignatura=new Estudiante_Asignatura();
        estudiante_asignatura.setStudent(studentService.FindStudentById(a.getId_student()));
        estudiante_asignatura.setAsignatura(a.getAsignatura());
        estudiante_asignatura.setComents(a.getComents());
        estudiante_asignatura.setInitial_date(a.getInitial_date());
        estudiante_asignatura.setFinish_date(a.getFinish_date());
        return estudiante_asignatura;
    }
    public StudentOutputDTO CreateStudentOutputDTO(Student student) {
        StudentOutputDTO s=new StudentOutputDTO();
        s.setId_student(student.getId_student());
        s.setNum_hours_week(student.getNum_hours_week());
        s.setComents(student.getComents());
        s.setId_profesor(student.getProfesor().getId_profesor());
        s.setBranch(student.getBranch());
        return s;
    }
    public PersonaOutputProfesorDTO CreatePersonaOutputProfesorDTO(Persona p){
        PersonaOutputProfesorDTO out=new PersonaOutputProfesorDTO();
        out.setId_persona(p.getId_persona());
        out.setUsuario(p.getUsuario());
        out.setPassword(p.getPassword());
        out.setName(p.getName());
        out.setSurname(p.getSurname());
        out.setCompany_email(p.getCompany_email());
        out.setPersonal_email(p.getPersonal_email());
        out.setCity(p.getCity());
        out.setActive(p.getActive());
        out.setCreated_date(p.getCreated_date());
        out.setImagen_url(p.getImagen_url());
        out.setTermination_date(p.getTermination_date());
        out.setId_profesor(p.getProfesor().getId_profesor());
        out.setComents(p.getProfesor().getComents());
        out.setBranch(p.getProfesor().getBranch());
        List<StudentOutputAsignaturaDTO> l=new ArrayList<>();
        for(Student s:p.getProfesor().getStudents()){
            l.add(this.CreateStudentOutputAsignaturaDTO(s));
        }
        out.setStudents(l);
        return out;
    }
    public Estudiante_AsignaturaOutputDTO CreateEstudiante_AsignaturaOutputDTO(Estudiante_Asignatura a){
        Estudiante_AsignaturaOutputDTO out=new Estudiante_AsignaturaOutputDTO();
        out.setId_asignatura(a.getId_asignatura());
        out.setId_student(a.getStudent().getId_student());
        out.setAsignatura(a.getAsignatura());
        out.setComents(a.getComents());
        out.setInitial_date(a.getInitial_date());
        out.setFinish_date(a.getFinish_date());
        return out;
    }
    public PersonaOutputEstudianteDTO CreatePersonaOutputEstudianteDTO(Persona p){
        PersonaOutputEstudianteDTO out=new PersonaOutputEstudianteDTO();
        out.setId_persona(p.getId_persona());
        out.setUsuario(p.getUsuario());
        out.setPassword(p.getPassword());
        out.setName(p.getName());
        out.setSurname(p.getSurname());
        out.setCompany_email(p.getCompany_email());
        out.setPersonal_email(p.getPersonal_email());
        out.setCity(p.getCity());
        out.setActive(p.getActive());
        out.setCreated_date(p.getCreated_date());
        out.setImagen_url(p.getImagen_url());
        out.setTermination_date(p.getTermination_date());
        out.setId_student(p.getStudent().getId_student());
        out.setNum_hours_week(p.getStudent().getNum_hours_week());
        out.setComents(p.getStudent().getComents());
        out.setId_profesor(p.getStudent().getProfesor().getId_profesor());
        out.setId_persona(p.getStudent().getPersona().getId_persona());
        out.setComentsProfesor(p.getStudent().getComents());
        out.setBranchProfesor(p.getStudent().getBranch());
        List<Estudiante_AsignaturaOutputDTO> l=new ArrayList<>();
        for(Estudiante_Asignatura e:p.getStudent().getAsignaturas()){
            l.add(this.CreateEstudiante_AsignaturaOutputDTO(e));
        }
        out.setAsignaturas(l);
        return out;
    }
    public StudentOutputAsignaturaDTO CreateStudentOutputAsignaturaDTO(Student student){
        StudentOutputAsignaturaDTO s=new StudentOutputAsignaturaDTO();
        s.setId_student(student.getId_student());
        s.setNum_hours_week(student.getNum_hours_week());
        s.setComents(student.getComents());
        s.setId_profesor(student.getProfesor().getId_profesor());
        s.setBranch(student.getBranch());
        List<Estudiante_AsignaturaOutputDTO> l=new ArrayList<>();
        for(Estudiante_Asignatura e:student.getAsignaturas()){
            l.add(this.CreateEstudiante_AsignaturaOutputDTO(e));
        }
        s.setAsignaturas(l);
        return s;
    }
}
