/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio.Practico.service.impl;

import Ejercicio.Practico.dao.UsuarioDao;
import Ejercicio.Practico.domain.Rol;
import Ejercicio.Practico.domain.Usuario;
import Ejercicio.Practico.service.UsuarioDetailsService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andy
 */
@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if (usuario == null){
            throw new UsernameNotFoundException(username);
        }
        var roles = new ArrayList <GrantedAuthority>();
          for (Rol rol : usuario.getRoles()) {
         roles.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombre()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}


