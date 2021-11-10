package com.example.DB1.Persona.infrastructure.controller;

import com.example.DB1.Persona.application.port.PersonaRepositorio;
import com.example.DB1.Persona.application.port.PersonaService;
import com.example.DB1.Persona.domain.Persona;
import com.example.DB1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.example.DB1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@RequestMapping("persona")
@RestController
public class UpdatePersonaController {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;

    @PutMapping("/{id}")
    public PersonaOutputDTO modificarPersona(@PathVariable String id, @RequestBody PersonaInputDTO p) throws Exception {


        Persona pers=personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE));
        if(p.getUsuario()!=null){
            pers.setUsuario(p.getUsuario());
        }
        if(p.getPassword()!=null){
            pers.setPassword(p.getPassword());
        }
        if(p.getName()!=null){
            pers.setName(p.getName());
        }
        if(p.getSurname()!=null){
            pers.setSurname(p.getSurname());
        }
        if(p.getCompany_email()!=null){
            pers.setCompany_email(p.getCompany_email());
        }
        if(p.getPersonal_email()!=null){
            pers.setPersonal_email(p.getPersonal_email());
        }
        if(p.getCity()!=null){
            pers.setCity(p.getCity());
        }
        if(p.getActive()!=null){
            pers.setActive(p.getActive());
        }
        if(p.getCreated_date()!=null){
            pers.setCreated_date(p.getCreated_date());
        }
        if(p.getImagen_url()!=null){
            pers.setImagen_url(p.getImagen_url());
        }
        if(p.getTermination_date()!=null){
            pers.setTermination_date(p.getTermination_date());
        }
        personaService.ComprabarNulos(pers);
        personaService.ComprobarLongitudUsuario(pers);
        personaRepositorio.save(pers);
        return new PersonaOutputDTO(pers);
    }
}
