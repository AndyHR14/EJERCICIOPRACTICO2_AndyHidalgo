/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ejercicio.Practico.dao;

import Ejercicio.Practico.domain.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Andy
 */
public interface FuncionDao  extends JpaRepository <Funcion,Long> {
    
}
