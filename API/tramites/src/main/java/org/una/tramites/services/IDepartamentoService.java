/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Departamento;

/**
 *
 * @author Luis
 */

public interface IDepartamentoService {
    public Optional<List<Departamento>> findAll();

    public Optional<Departamento> findById(Long id);

    public Departamento create(Departamento departamento);

    public Optional<Departamento> update(Departamento departamento, Long id);

    public void delete(Long id);

    public void deleteAll();
    
}
