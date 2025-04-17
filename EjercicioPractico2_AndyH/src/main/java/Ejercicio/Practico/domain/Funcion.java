/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio.Practico.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Andy
 */
@Data
@Entity
@Table(name="funcion")
public class Funcion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcion")
    private Long idFuncion;
    private String fecha;
    private String hora;
    private String sala;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_pelicula")
    Pelicula pelicula;
    
    public Funcion(){
     
    }
    
    public Funcion(String sala, boolean activo){
        this.sala = sala;
        this.activo = activo;
    }
}
