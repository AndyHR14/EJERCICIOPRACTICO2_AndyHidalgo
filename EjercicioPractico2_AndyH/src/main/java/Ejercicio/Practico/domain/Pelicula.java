/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
 package Ejercicio.Practico.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Andy
 */ 
@Data
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long idPelicula;
    private String titulo;
    private String tipo;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_pelicula", updatable = false)
     List<Funcion> funciones;

    public Pelicula() {
    }

    public Pelicula(String titulo, boolean activo) {
        this.titulo = titulo;
        this.activo = activo;
    }
}
