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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Andy
 */
@Data
@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservas")
    private Long idReservas;
    private int cantidad;
    private boolean activo;

    //@ManyToOne
    //@JoinColumn(name = "id_usuario", updatable = false)
     //List<Usuario> funciones;

    public Reservas() {
    }

    public Reservas(int cantidad, boolean activo) {
        this.cantidad = cantidad;
        this.activo = activo;
    }
}
