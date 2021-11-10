package com.example.DB1.Profesor.application.port;

import com.example.DB1.Profesor.domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProfesorServiceImpl implements ProfesorService{
    @Autowired
    ProfesorRepositorio profesorRepositorio;
    @Override
    public void ComprobarNulos(Profesor p) throws Exception {
        if(p.getBranch()==null){
            throw new Exception("Branch no puede ser null");
        }

    }

    @Override
    public Profesor FindProfesorById(String id) {
        Profesor p=profesorRepositorio.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return p;
    }

}
