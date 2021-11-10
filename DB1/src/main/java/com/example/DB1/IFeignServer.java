package com.example.DB1;

import com.example.DB1.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Feign", url="http://localhost:8080")
public interface IFeignServer {
    @GetMapping("/profesor/{id}")
    ResponseEntity<ProfesorOutputDTO> getProfesor(@PathVariable String id);
}
