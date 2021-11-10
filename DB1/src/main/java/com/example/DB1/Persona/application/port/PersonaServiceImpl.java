package com.example.DB1.Persona.application.port;

import com.example.DB1.Persona.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Override
    public void ComprabarNulos(Persona p) throws Exception {
        if(p.getUsuario()==null){
            throw new Exception("Usuario no puede ser nulo");
        }
        if(p.getPassword()==null){
            throw new Exception("Password no puede ser nulo");
        }
        if(p.getName()==null){
            throw new Exception("Name no puede ser nulo");
        }
        if(p.getCompany_email()==null){
            throw new Exception("Company_email no puede ser nulo");
        }
        if(p.getPersonal_email()==null){
            throw new Exception("Personal_email no puede ser nulo");
        }
        if(p.getCity()==null){
            throw new Exception("Ciudad no puede ser nulo");
        }
        if(p.getActive()==null){
            throw new Exception("Active no puede ser nulo");
        }
        if(p.getCreated_date()==null){
            throw new Exception("Created date no puede ser nulo");
        }
    }

    @Override
    public void ComprobarLongitudUsuario(Persona p) throws Exception {
        if(p.getUsuario().length()>10||p.getUsuario().length()<6){
            throw new Exception("Formato de usuario incorrecto, la longitud debe ser entre 6 y 10 ");
        }
    }
    public void ComprobarAsignado(Persona p) throws Exception {
        if(p.getStudent()!=null || p.getProfesor()!=null){
            throw new Exception("Esta persona tiene un estudiante/profesor asignado");
        }
    }

    @Override
    public Persona FindPersonaById(String id) {
        Persona p=personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return p;
    }

    @Override
    public void EsEstudiante(Persona p) throws Exception {
        if(p.getStudent()!=null){
            throw new Exception("Esta persona es un estudiante, no puede ser un profesor");
        }
    }

    @Override
    public void EsProfesor(Persona p) throws Exception {
        if(p.getProfesor()!=null){
            throw new Exception("Esta persona es un profesor, no puede ser estudiante");
        }
    }

}
