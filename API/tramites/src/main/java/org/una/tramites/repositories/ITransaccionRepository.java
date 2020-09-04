/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import org.una.tramites.entities.Transaccion;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author rache
 */

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long>{
    
   
    public Optional<Transaccion> findById(Long id);

    public Optional<List<Transaccion>> findAll(Transaccion transaccion);
   
    public Transaccion save(Transaccion transaccion);
  
    public void deleteById(Long id);
 
    public void deleteAll();
    
}
