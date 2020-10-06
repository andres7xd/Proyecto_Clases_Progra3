/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.Parametros_GeneralesDTO;

/**
 *
 * @author andre
 */
public interface IParametros_GeneralesService {

    public Optional<Parametros_GeneralesDTO> findById(Long id);

    public Parametros_GeneralesDTO create(Parametros_GeneralesDTO parametrosGeneralesDTO);

    public Optional<Parametros_GeneralesDTO> update(Parametros_GeneralesDTO parametrosGeneralesDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<List<Parametros_GeneralesDTO>> findAll();

}
