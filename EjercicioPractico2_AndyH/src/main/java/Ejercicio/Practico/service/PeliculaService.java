/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ejercicio.Practico.service;

import Ejercicio.Practico.domain.Pelicula;
import java.util.List;

/**
 *
 * @author Andy
 */
public interface PeliculaService {
 
    public List<Pelicula> getPeliculas(boolean activos);
 
    public Pelicula getPelicula(Pelicula pelicula);

    public void save(Pelicula pelicula);
  
    public void delete(Pelicula pelicula);
}
