package com.example.DB1.Profesor.application.port;

import com.example.DB1.Profesor.domain.Profesor;

public interface ProfesorService {
    void ComprobarNulos(Profesor p) throws Exception;
    Profesor FindProfesorById(String id);
}
