package com.example.DB1.Student.infrastructure.controller.dto.output;

import com.example.DB1.Persona.domain.Persona;
import com.example.DB1.Student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFullOutputDTO extends StudentOutputDTO {

    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public StudentFullOutputDTO(Student student) {
        this.setId_student(student.getId_student());
        this.setNum_hours_week(student.getNum_hours_week());
        this.setComents(student.getComents());
        this.setId_profesor(student.getProfesor().getId_profesor());
        Persona p=student.getPersona();
        this.setUsuario(p.getUsuario());
        this.setPassword(p.getPassword());
        this.setName(p.getName());
        this.setSurname(p.getSurname());
        this.setCompany_email(p.getCompany_email());
        this.setPersonal_email(p.getPersonal_email());
        this.setCity(p.getCity());
        this.setActive(p.getActive());
        this.setCreated_date(p.getCreated_date());
        this.setImagen_url(p.getImagen_url());
        this.setTermination_date(p.getTermination_date());
    }
}
