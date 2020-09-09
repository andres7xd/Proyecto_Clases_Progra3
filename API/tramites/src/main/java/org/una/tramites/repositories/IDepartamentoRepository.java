/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.tramites.entities.Departamento;

/**
 *
 * @author Luis
 */
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {

    //@Query("SELECT u FROM Departamento u WHERE v.estado= estado_departamento")
    public List<Departamento> findByEstadoContaining(Boolean estado);
}
