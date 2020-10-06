/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.Archivos_RelacionadosDTO;

/**
 *
 * @author Luis
 */
public interface IArchivos_RelacionadosService {
    
    public Optional<List<Archivos_RelacionadosDTO>> findAll();

    public Optional<Archivos_RelacionadosDTO> findById(Long id);

    public Archivos_RelacionadosDTO create(Archivos_RelacionadosDTO archivos_relacionadosDTO);

    public Optional<Archivos_RelacionadosDTO> update(Archivos_RelacionadosDTO archivos_relacionadosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
