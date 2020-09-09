/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.tramites.entities.TramiteTipo;

/**
 *
 * @author andre
 */
public interface ITramiteTipoRepository extends JpaRepository<TramiteTipo, Long> {
     @Query("SELECT u FROM TramiteTipo u   WHERE u.departamento = departamento_id ")
     public List<TramiteTipo> findByDepartamentoId(@Param("departamento_id")Long departamentoid);
     
     @Query("SELECT u FROM TramiteTipo u   WHERE u.descripciontramite = descripcion_tramitetipo ")
     public List<TramiteTipo> findByDescripcion(@Param("descripcion_tramitetipo")String descripcion);
}
