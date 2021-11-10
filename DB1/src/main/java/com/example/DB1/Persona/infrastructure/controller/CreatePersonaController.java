package com.example.DB1.Persona.infrastructure.controller;

import com.example.DB1.Persona.domain.Persona;
import com.example.DB1.Persona.application.port.PersonaRepositorio;
import com.example.DB1.Persona.application.port.PersonaService;
import com.example.DB1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.example.DB1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("persona")
@RestController
public class CreatePersonaController {
    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    PersonaService personaService;

    @PostMapping
    public PersonaOutputDTO anadirPersona(@RequestBody PersonaInputDTO p) throws Exception {
        Persona pers=new Persona(p);
        personaService.ComprabarNulos(pers);
        personaService.ComprobarLongitudUsuario(pers);
        personaRepositorio.save(pers);
        PersonaOutputDTO out=new PersonaOutputDTO(pers);
        return out;


    }
}
