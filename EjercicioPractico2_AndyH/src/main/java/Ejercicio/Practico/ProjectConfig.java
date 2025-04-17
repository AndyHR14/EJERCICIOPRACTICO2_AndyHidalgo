/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio.Practico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Andy
 */
@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/", "/index", "/errores/**",
                                "/registro/**", "/js/**", "/webjars/**")
                        .permitAll()
                        .requestMatchers(
                                "/funcion/nuevo", "/funcion/guardar",
                                "/funcion/modificar/**", "/funcion/eliminar/**",
                                "/pelicula/nuevo", "/pelicula/guardar",
                                "/pelicula/modificar/**", "/pelicula/eliminar/**",
                                "/usuario/nuevo", "/usuario/guardar",
                                "/usuario/modificar/**", "/usuario/eliminar/**",
                                "/usuario/listado"
                        ).hasRole("ADMIN")
                        .requestMatchers(
                                "/funcion/listado",
                                "/pelicula/listado",
                                "/facturar/carrito",
                                "/contacto"
                        ).hasRole("USUARIO")
                )
                .formLogin((form) -> form
                        .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}