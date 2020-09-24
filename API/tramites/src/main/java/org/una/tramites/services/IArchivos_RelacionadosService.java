/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Archivos_Relacionados;
import org.una.tramites.entities.Notas;

/**
 *
 * @author Luis
 */
public interface IArchivos_RelacionadosService {
    
    public Optional<List<Archivos_Relacionados>> findAll();

    public Optional<Archivos_Relacionados> findById(Long id);

    public Archivos_Relacionados create(Archivos_Relacionados archivos_relacionados);

    public Optional<Archivos_Relacionados> update(Archivos_Relacionados archivos_relacionados, Long id);

    public void delete(Long id);

    public void deleteAll();
}
