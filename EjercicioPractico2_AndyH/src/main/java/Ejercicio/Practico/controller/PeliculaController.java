/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio.Practico.controller;

import Ejercicio.Practico.domain.Pelicula;
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
@RequestMapping("/pelicula")
public class PeliculaController {
  

    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var peliculas = peliculaService.getPeliculas(false);
        model.addAttribute("peliculas", peliculas);        
        model.addAttribute("totalPeliculas",peliculas.size());
        return "/pelicula/listado";
    }
    
     @GetMapping("/nuevo")
    public String peliculaNuevo(Pelicula pelicula) {
        return "/pelicula/modifica";
    }

    @PostMapping("/guardar")
    public String peliculaGuardar(Pelicula pelicula) {        
        peliculaService.save(pelicula);
        return "redirect:/pelicula/listado";
    }

    @GetMapping("/eliminar/{idPelicula}")
    public String peliculaEliminar(Pelicula pelicula) {
        peliculaService.delete(pelicula);
        return "redirect:/pelicula/listado";
    }

    @GetMapping("/modificar/{idPelicula}")
    public String peliculaModificar(Pelicula pelicula, Model model) {
        pelicula = peliculaService.getPelicula(pelicula);
        model.addAttribute("pelicula", pelicula);
        
        var peliculas = peliculaService.getPeliculas(false);
        model.addAttribute("peliculas", peliculas);
        
        return "/pelicula/modifica";
    }   
}