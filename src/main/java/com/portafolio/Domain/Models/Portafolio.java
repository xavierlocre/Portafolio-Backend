package com.portafolio.Domain.Models;


import jakarta.persistence.*;

@Entity
@Table
public class Portafolio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String imagen;
    private String git;
    private String descripcion;

    public Portafolio() {
    }

    public Portafolio(Integer id, String titulo, String imagen, String git, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.git = git;
        this.descripcion = descripcion;
    }

    public Portafolio(String titulo, String imagen, String git, String descripcion) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.git = git;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}