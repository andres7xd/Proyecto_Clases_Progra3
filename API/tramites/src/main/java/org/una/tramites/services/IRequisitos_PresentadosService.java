/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Requisitos_Presentados;

/**
 *
 * @author Luis
 */
public interface IRequisitos_PresentadosService {
    
    public Optional<List<Requisitos_Presentados>> findAll();

    public Optional<Requisitos_Presentados> findById(Long id);

    public Requisitos_Presentados create(Requisitos_Presentados requisitos_presentados);

    public Optional<Requisitos_Presentados> update(Requisitos_Presentados requisitos_presentados, Long id);

    public void delete(Long id);

    public void deleteAll();
}
