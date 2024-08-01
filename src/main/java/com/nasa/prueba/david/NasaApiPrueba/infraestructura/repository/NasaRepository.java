package com.nasa.prueba.david.NasaApiPrueba.infraestructura.repository;

import com.nasa.prueba.david.NasaApiPrueba.dominio.entities.NasaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NasaRepository extends JpaRepository<NasaData, Long> {
}
