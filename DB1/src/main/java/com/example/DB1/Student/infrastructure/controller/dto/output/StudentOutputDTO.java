package com.example.DB1.Student.infrastructure.controller.dto.output;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDTO {
    private String id_student;
    private Integer num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;

}
