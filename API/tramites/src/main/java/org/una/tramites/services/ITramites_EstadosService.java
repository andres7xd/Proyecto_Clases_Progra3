/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Tramites_Estados;

/**
 *
 * @author Luis
 */
public interface ITramites_EstadosService {
    
    public Optional<List<Tramites_Estados>> findAll();

    public Optional<Tramites_Estados> findById(Long id);

    public Tramites_Estados create(Tramites_Estados tramites_estados);

    public Optional<Tramites_Estados> update(Tramites_Estados tramites_estados, Long id);

    public void delete(Long id);

    public void deleteAll();
}
