/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

/**
 *
 * @author rache
 */
import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.PermisoDTO;

public interface IPermisoService {

    public Optional<List<PermisoDTO>> findAll();

    public Optional<PermisoDTO> findById(Long id);

    public Optional<List<PermisoDTO>> findByEstado(boolean estado);

//    public Optional<List<Permiso>> findByFechaRegistroBetween(Date startDate, Date endDate);
    
    public PermisoDTO create(PermisoDTO permisoDTO);

    public Optional<PermisoDTO> update(PermisoDTO permisoDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<PermisoDTO> findByCodigo(String codigo);

}
