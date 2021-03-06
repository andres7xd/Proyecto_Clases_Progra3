/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.DepartamentoDTO;

/**
 *
 * @author Luis
 */
public interface IDepartamentoService {

    public Optional<List<DepartamentoDTO>> findAll();

    public Optional<DepartamentoDTO> findById(Long id);

    public DepartamentoDTO create(DepartamentoDTO departamentoDTO);

    public Optional<DepartamentoDTO> update(DepartamentoDTO departamentoDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

}
