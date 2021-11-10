package com.example.DB1.Profesor.infrastructure.controller.dto.output;


import com.example.DB1.Profesor.domain.Profesor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDTO {
    private String id_profesor;
    private String id_persona;
    private String coments;
    private String branch;
    public ProfesorOutputDTO(Profesor p){
        this.setId_profesor(p.getId_profesor());
        this.setId_persona(p.getPersona().getId_persona());
        this.setComents(p.getComents());
        this.setBranch(p.getBranch());
    }
}
