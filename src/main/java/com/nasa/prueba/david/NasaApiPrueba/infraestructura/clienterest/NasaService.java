package com.nasa.prueba.david.NasaApiPrueba.infraestructura.clienterest;
import com.nasa.prueba.david.NasaApiPrueba.dominio.dto.CustomPageResponse;
import com.nasa.prueba.david.NasaApiPrueba.dominio.entities.NasaData;
import com.nasa.prueba.david.NasaApiPrueba.exceptions.InvalidRequestException;
import com.nasa.prueba.david.NasaApiPrueba.infraestructura.repository.NasaRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NasaService {
    @Autowired
    NasaRepository nasaItemRepository;
    public CustomPageResponse getNasaData(int page, int size){

        //validamos los parámetros que recibimos por la URL
        if (page < 0 || size <= 0) {
            throw new InvalidRequestException("Los valores de página y tamaño deben ser números mayores a 0");
        }
        //Obtenemos los datos y los ordenamos descendentemente por el campo id
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<NasaData> nasaItems = nasaItemRepository.findAll(pageable);

        List<NasaData> nasaItemResponses = nasaItems.getContent();

        //Utilizamos un DTO para darle un formato más simple a la respuesta paginada
        return new CustomPageResponse(
                nasaItemResponses,
                nasaItems.getNumber(),
                nasaItems.getSize(),
                nasaItems.getTotalElements(),
                nasaItems.getTotalPages()
        );

    }
}
