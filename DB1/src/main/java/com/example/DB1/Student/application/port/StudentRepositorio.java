package com.example.DB1.Student.application.port;

import com.example.DB1.Student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositorio extends JpaRepository<Student, String> {
}
