/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio.Practico.controller;

import Ejercicio.Practico.domain.Funcion;
import Ejercicio.Practico.service.FuncionService;
import Ejercicio.Practico.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Andy
 */
@Controller
@RequestMapping("/funcion")
public class FuncionController {
  
    @Autowired
    private FuncionService funcionService;
    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var funcions = funcionService.getFuncions(false);
        model.addAttribute("funcions", funcions);
        var peliculas = peliculaService.getPeliculas(false);
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("totalFuncions",funcions.size());
        return "/funcion/listado";
    }
    
     @GetMapping("/nuevo")
    public String funcionNuevo(Funcion funcion) {
        return "/funcion/modifica";
    }
    
    @PostMapping("/guardar")
    public String funcionGuardar(Funcion funcion) {        
        funcionService.save(funcion);
        return "redirect:/funcion/listado";
    }

    @GetMapping("/eliminar/{idFuncion}")
    public String funcionEliminar(Funcion funcion) {
        funcionService.delete(funcion);
        return "redirect:/funcion/listado";
    }

    @GetMapping("/modificar/{idFuncion}")
    public String funcionModificar(Funcion funcion, Model model) {
        funcion = funcionService.getFuncion(funcion);
        model.addAttribute("funcion", funcion);
        
        var peliculas = peliculaService.getPeliculas(false);
        model.addAttribute("peliculas", peliculas);
        
        return "/funcion/modifica";
    }   
}


