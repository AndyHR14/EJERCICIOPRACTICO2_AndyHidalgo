/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio.Practico.service.impl;

import Ejercicio.Practico.dao.FuncionDao;
import Ejercicio.Practico.domain.Funcion;
import Ejercicio.Practico.service.FuncionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andy
 */
@Service
public class FuncionServiceImpl implements FuncionService {
      @Autowired
    private FuncionDao funcionDao;

    @Override
    @Transactional(readOnly=true)
    public List<Funcion> getFuncions(boolean activos) {
        var lista=funcionDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Funcion getFuncion(Funcion funcion){
        return funcionDao.findById(funcion.getIdFuncion()).orElse(null);
    }
    @Override
    @Transactional
    public void save(Funcion funcion) {
        funcionDao.save(funcion);
    }
    
    @Override
    @Transactional
    public void delete(Funcion funcion){
        funcionDao.delete(funcion);
    }
}

