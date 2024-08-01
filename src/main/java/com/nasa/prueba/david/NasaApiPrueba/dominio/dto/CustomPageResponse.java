package com.nasa.prueba.david.NasaApiPrueba.dominio.dto;

import com.nasa.prueba.david.NasaApiPrueba.dominio.entities.NasaData;
import lombok.Data;

import java.util.List;

@Data
public class CustomPageResponse{

    private List<NasaData> content;
    private int pageNumber;
    private int pageSize;
    private Long totalItems;
    private int totalPages;

    public CustomPageResponse(List<NasaData> content, int pageNumber, int pageSize, Long totalItems, int totalPages) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }
}
