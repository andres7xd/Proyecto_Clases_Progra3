/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Tramites_Cambios_Estados;

/**
 *
 * @author andre
 */
public interface ITramites_Cambios_EstadosService {

    public Optional<Tramites_Cambios_Estados> findById(Long id);

    public Tramites_Cambios_Estados create(Tramites_Cambios_Estados tramitesCambiosEstados);

    public Optional<Tramites_Cambios_Estados> update(Tramites_Cambios_Estados tramitesCambiosEstados, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<List<Tramites_Cambios_Estados>>findAll();
}
