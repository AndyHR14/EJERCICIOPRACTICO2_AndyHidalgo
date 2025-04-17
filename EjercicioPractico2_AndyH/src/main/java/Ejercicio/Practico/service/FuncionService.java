/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ejercicio.Practico.service;

import Ejercicio.Practico.domain.Funcion;
import java.util.List;

/**
 *
 * @author Andy
 */
public interface FuncionService {  
    public List<Funcion> getFuncions(boolean activos);
 
    public Funcion getFuncion(Funcion funcion);

    public void save(Funcion funcion);
  
    public void delete(Funcion funcion);
}
