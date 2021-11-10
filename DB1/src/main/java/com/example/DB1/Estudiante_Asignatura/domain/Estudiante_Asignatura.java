package com.example.DB1.Estudiante_Asignatura.domain;

import com.example.DB1.StringPrefixedSequenceIdGenerator;
import com.example.DB1.Student.domain.Student;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante_Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignatura_seq")
    @GenericGenerator(
            name = "asignatura_seq",
            strategy = "com.example.DB1.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "ASG"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    private String id_asignatura;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_student")
    private Student student;
    private String asignatura;
    private String coments;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date initial_date;
    @Temporal(TemporalType.DATE)
    private Date finish_date;
}
