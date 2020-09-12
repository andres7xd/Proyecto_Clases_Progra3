/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tramites.entities.Permiso;

/**
 *
 * @author rache
 */
public interface IPermisoRepository extends JpaRepository<Permiso, Long> {

    public List<Permiso> findByEstadoContaining(Boolean estado);

    public Permiso findByCodigo(String codigo);

//    public List<Permiso> findByCodigoAproximate(String codigo);

}
