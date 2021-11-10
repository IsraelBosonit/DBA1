package com.example.DB1.Estudiante_Asignatura.infrastructure.controller.dto.output;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante_AsignaturaOutputDTO {
    private String id_asignatura;
    private String id_student;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;

}
