/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.TramiteTipoDTO;

/**
 *
 * @author andre
 */
public interface ITramiteTipoService {
    
     public Optional<List<TramiteTipoDTO>> findAll();

    public Optional<TramiteTipoDTO> findById(Long id);
    
    public TramiteTipoDTO create(TramiteTipoDTO tramiteTipoDTO);

    public Optional<TramiteTipoDTO> update(TramiteTipoDTO tramiteTipoDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
    
    public Optional<List<TramiteTipoDTO>> findByDepartamentoId(Long id);
    
    public Optional<List<TramiteTipoDTO>> findByDescripcion(String descripcion);
}
