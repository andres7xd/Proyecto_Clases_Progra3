/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.Tramites_EstadosDTO;

/**
 *
 * @author Luis
 */
public interface ITramites_EstadosService {
    
    public Optional<List<Tramites_EstadosDTO>> findAll();

    public Optional<Tramites_EstadosDTO> findById(Long id);

    public Tramites_EstadosDTO create(Tramites_EstadosDTO tramites_estadosDTO);

    public Optional<Tramites_EstadosDTO> update(Tramites_EstadosDTO tramites_estadosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
