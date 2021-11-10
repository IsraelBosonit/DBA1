package com.example.DB1.Student.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDTO {
    private String id_persona;
    private Integer num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;
}
