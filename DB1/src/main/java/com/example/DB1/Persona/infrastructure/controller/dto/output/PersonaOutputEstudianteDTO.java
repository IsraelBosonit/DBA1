package com.example.DB1.Persona.infrastructure.controller.dto.output;

import com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.output.Estudiante_AsignaturaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputEstudianteDTO extends PersonaOutputDTO{
    private String id_student;
    private Integer num_hours_week;
    private String coments;
    private String branch;
    private String id_profesor;
    private String id_persona;
    private String comentsProfesor;
    private String branchProfesor;
    private List<Estudiante_AsignaturaOutputDTO> asignaturas;

}
