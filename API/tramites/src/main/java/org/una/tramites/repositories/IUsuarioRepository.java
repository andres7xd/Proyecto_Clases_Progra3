/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import java.util.Date;
import java.util.List;
import javax.management.Query;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.Usuario;

/**
 *
 * @author rache
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> { 

 

    public Usuario findByCedulaAndPasswordEncriptado(String cedula, String passwordEncriptado); 

 

    public List<Usuario> findByCedulaContaining(String cedula); 

 

    public List<Usuario> findByNombreCompletoContainingIgnoreCase(String nombreCompleto); 

    public Usuario findByNombreCompleto(String nombreCompleto);
    
    //Falta el query de contraseña.

   
} 

