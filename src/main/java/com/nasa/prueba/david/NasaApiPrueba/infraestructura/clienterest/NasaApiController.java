package com.nasa.prueba.david.NasaApiPrueba.infraestructura.clienterest;

import com.nasa.prueba.david.NasaApiPrueba.dominio.dto.CustomPageResponse;
import com.nasa.prueba.david.NasaApiPrueba.dominio.entities.NasaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NasaApiController {

    @Autowired
    NasaService nasaService;

    @GetMapping("/nasa-information")
    public ResponseEntity<CustomPageResponse> fetchData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(nasaService.getNasaData(page, size));
    }
}
