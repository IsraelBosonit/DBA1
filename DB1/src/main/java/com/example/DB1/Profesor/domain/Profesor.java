package com.example.DB1.Profesor.domain;

import com.example.DB1.Persona.domain.Persona;
import com.example.DB1.StringPrefixedSequenceIdGenerator;
import com.example.DB1.Student.domain.Student;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    @GenericGenerator(
            name = "profesor_seq",
            strategy = "com.example.DB1.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "PRF"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    private String id_profesor;
    @JoinColumn(name="id_persona")
    @OneToOne(fetch = FetchType.LAZY)
    private Persona persona;
    private String coments;
    @NotNull
    private String branch;
    @OneToMany(mappedBy = "profesor")
    private List<Student> students;

}
