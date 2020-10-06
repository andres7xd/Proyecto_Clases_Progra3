/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.Requisitos_PresentadosDTO;

/**
 *
 * @author Luis
 */
public interface IRequisitos_PresentadosService {
    
    public Optional<List<Requisitos_PresentadosDTO>> findAll();

    public Optional<Requisitos_PresentadosDTO> findById(Long id);

    public Requisitos_PresentadosDTO create(Requisitos_PresentadosDTO requisitos_presentadosDTO);

    public Optional<Requisitos_PresentadosDTO> update(Requisitos_PresentadosDTO requisitos_presentadosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
