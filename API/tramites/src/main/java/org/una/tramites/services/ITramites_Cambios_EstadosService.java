/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.Tramites_Cambios_EstadosDTO;

/**
 *
 * @author andre
 */
public interface ITramites_Cambios_EstadosService {

    public Optional<Tramites_Cambios_EstadosDTO> findById(Long id);

    public Tramites_Cambios_EstadosDTO create(Tramites_Cambios_EstadosDTO tramites_Cambios_EstadosDTO);

    public Optional<Tramites_Cambios_EstadosDTO> update(Tramites_Cambios_EstadosDTO tramites_Cambios_EstadosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<List<Tramites_Cambios_EstadosDTO>>findAll();
}
