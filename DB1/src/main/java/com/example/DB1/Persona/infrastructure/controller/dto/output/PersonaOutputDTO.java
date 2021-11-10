package com.example.DB1.Persona.infrastructure.controller.dto.output;

import com.example.DB1.Persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputDTO {
    private String id_persona;
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


    public PersonaOutputDTO(Persona p){
        this.setId_persona(p.getId_persona());
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

