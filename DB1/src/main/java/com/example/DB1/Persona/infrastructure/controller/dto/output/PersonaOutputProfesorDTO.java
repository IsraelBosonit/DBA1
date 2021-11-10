package com.example.DB1.Persona.infrastructure.controller.dto.output;


import com.example.DB1.Student.infrastructure.controller.dto.output.StudentOutputAsignaturaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaOutputProfesorDTO extends PersonaOutputDTO{
    private String id_profesor;
    private String coments;
    private String branch;
    private List<StudentOutputAsignaturaDTO> students;

}
