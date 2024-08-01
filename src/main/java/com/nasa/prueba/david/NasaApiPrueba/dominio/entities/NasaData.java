package com.nasa.prueba.david.NasaApiPrueba.dominio.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class NasaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String href;
    String center;
    String title;
    String nasa_id;

    @CreatedDate
    LocalDateTime created_at;

    public NasaData(String href, String center, String title, String nasa_id) {
        this.href = href;
        this.center = center;
        this.title = title;
        this.nasa_id = nasa_id;
    }

    public NasaData(Long id, String href, String center, String title, String nasa_id, LocalDateTime created_at) {
        this.id = id;
        this.href = href;
        this.center = center;
        this.title = title;
        this.nasa_id = nasa_id;
        this.created_at = created_at;
    }

    public NasaData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNasa_id() {
        return nasa_id;
    }

    public void setNasa_id(String nasa_id) {
        this.nasa_id = nasa_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
