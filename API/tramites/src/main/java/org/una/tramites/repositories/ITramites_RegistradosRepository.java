/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.Tramites_Registrados;

/**
 *
 * @author Luis
 */
public interface ITramites_RegistradosRepository extends JpaRepository<Tramites_Registrados, Long>{
    
}
