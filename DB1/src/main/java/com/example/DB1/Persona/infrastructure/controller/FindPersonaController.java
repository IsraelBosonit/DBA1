package com.example.DB1.Persona.infrastructure.controller;

import com.example.DB1.Auxiliar;
import com.example.DB1.IFeignServer;
import com.example.DB1.Persona.application.port.PersonaRepositorio;
import com.example.DB1.Persona.application.port.PersonaService;
import com.example.DB1.Profesor.application.port.ProfesorService;
import com.example.DB1.Persona.domain.Persona;
import com.example.DB1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.example.DB1.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@RequestMapping("persona")
@RestController
public class FindPersonaController {

    @Autowired
    PersonaRepositorio personaRepositorio;
    @Autowired
    Auxiliar auxiliar;
    @Autowired
    IFeignServer iFeignServer;
    @Autowired
    EntityManager em;

    public static final String GREATER_THAN="greater";
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";

    @GetMapping("/{id}")
    public PersonaOutputDTO getPersonabyId(@PathVariable String id, @RequestParam(name="outputType", defaultValue = "simple") String outputType)throws Exception{
        Persona p=personaRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        PersonaOutputDTO out = null;
        if(outputType.equals("simple")){
            out=new PersonaOutputDTO(p);
        }
        if(outputType.equals("profesor")){
            out=auxiliar.CreatePersonaOutputProfesorDTO(p);
        }
        if(outputType.equals("estudiante")){
            out= auxiliar.CreatePersonaOutputEstudianteDTO(p);
        }
        return out;
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDTO> getPersonabyNombre(@PathVariable String nombre, @RequestParam(name="outputType", defaultValue = "simple") String outputType)throws Exception{
        List<Persona> l=personaRepositorio.findByusuario(nombre);
        List<PersonaOutputDTO> lout=new ArrayList<>();
        for (Persona p : l) {
            if(outputType.equals("simple")){
                lout.add(new PersonaOutputDTO(p));
            }
            if(outputType.equals("profesor")){
                lout.add(auxiliar.CreatePersonaOutputProfesorDTO(p));
            }
            if(outputType.equals("estudiante")){
                lout.add(auxiliar.CreatePersonaOutputEstudianteDTO(p));
            }
        }
        return lout;
    }
    @GetMapping
    public List<PersonaOutputDTO> getAll(@RequestParam(name="outputType", defaultValue = "simple") String outputType)throws Exception{
        List<Persona> l=personaRepositorio.findAll();
        List<PersonaOutputDTO> lout=new ArrayList<>();
        for (Persona p : l) {
            if(outputType.equals("simple")){
                lout.add(new PersonaOutputDTO(p));
            }
            if(outputType.equals("profesor")){
                lout.add(auxiliar.CreatePersonaOutputProfesorDTO(p));
            }
            if(outputType.equals("estudiante")){
                lout.add(auxiliar.CreatePersonaOutputEstudianteDTO(p));
            }
        }
        return lout;
    }
    @GetMapping("/template/profesor/{id}")
    public ResponseEntity<ProfesorOutputDTO> getProfesorTemplate(@PathVariable String id){
        ResponseEntity<ProfesorOutputDTO> responseEntity=new RestTemplate().getForEntity("http://localhost:8080/profesor/"+id,ProfesorOutputDTO.class);
        return responseEntity;
    }
    @GetMapping("/profesor/{id}")
    public ResponseEntity<ProfesorOutputDTO> getProfesor(@PathVariable String id){
        ResponseEntity<ProfesorOutputDTO> responseEntity=iFeignServer.getProfesor(id);
        return responseEntity;
    }
    @GetMapping("/get")
    public List<Persona> getData(@RequestParam(required=false) String usuario,
                                 @RequestParam(required=false) String name,
                                 @RequestParam(required=false) String surname,
                                 @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date created_date, @RequestParam(required=false) String dateCondition			)
    {
        HashMap<String, Object> data=new HashMap<>();

        if (usuario!=null)
            data.put("usuario",usuario);
        if (name!=null)
            data.put("name",name);
        if (surname!=null)
            data.put("surname",surname);
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        if (!dateCondition.equals(GREATER_THAN) && 	!dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
            dateCondition=GREATER_THAN;
        if (created_date!=null)
        {
            data.put("created_date",created_date);
            data.put("dateCondition",dateCondition);
        }

        return personaRepositorio.getData(data);

    }

}
