package com.example.DB1.Persona.domain;

import com.example.DB1.StringPrefixedSequenceIdGenerator;
import com.example.DB1.Profesor.domain.Profesor;
import com.example.DB1.Student.domain.Student;
import com.example.DB1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @GenericGenerator(
            name = "persona_seq",
            strategy = "com.example.DB1.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "PRS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    private String id_persona;
    @NotNull
    private String usuario;
    @NotNull
    private String password;
    @NotNull
    private String name;
    private String surname;
    @NotNull
    private String company_email;
    @NotNull
    private String personal_email;
    @NotNull
    private String city;
    @NotNull
    private Boolean active;
    @NotNull
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;
    @OneToOne(mappedBy="persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Profesor profesor;
    public Persona(PersonaInputDTO in){
        this.setUsuario(in.getUsuario());
        this.setPassword(in.getPassword());
        this.setName(in.getName());
        this.setSurname(in.getSurname());
        this.setCompany_email(in.getCompany_email());
        this.setPersonal_email(in.getPersonal_email());
        this.setCity(in.getCity());
        this.setActive(in.getActive());
        this.setCreated_date(in.getCreated_date());
        this.setImagen_url(in.getImagen_url());
        this.setTermination_date(in.getTermination_date());
    }

}
