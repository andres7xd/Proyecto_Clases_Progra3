/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Tramites_Registrados;

/**
 *
 * @author Luis
 */
public interface ITramites_RegistradosService {
    
    public Optional<List<Tramites_Registrados>> findAll();

    public Optional<Tramites_Registrados> findById(Long id);

    public Tramites_Registrados create(Tramites_Registrados tramites_registrados);

    public Optional<Tramites_Registrados> update(Tramites_Registrados tramites_registrados, Long id);

    public void delete(Long id);

    public void deleteAll();
}
