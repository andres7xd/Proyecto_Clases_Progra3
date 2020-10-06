/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.Tramites_RegistradosDTO;

/**
 *
 * @author Luis
 */
public interface ITramites_RegistradosService {
    
    public Optional<List<Tramites_RegistradosDTO>> findAll();

    public Optional<Tramites_RegistradosDTO> findById(Long id);

    public Tramites_RegistradosDTO create(Tramites_RegistradosDTO tramites_RegistradosDTO);

    public Optional<Tramites_RegistradosDTO> update(Tramites_RegistradosDTO tramites_RegistradosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
