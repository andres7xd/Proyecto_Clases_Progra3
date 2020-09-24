/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Tramites_Cambios_Estados;
import org.una.tramites.repositories.ITramites_Cambios_EstadosRepository;

/**
 *
 * @author andre
 */
@Service
public class Tramites_Cambios_EstadosServiceImplementation implements ITramites_Cambios_EstadosService {
    
    @Autowired
    private ITramites_Cambios_EstadosRepository tramites_cambios_estadosRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Tramites_Cambios_Estados>> findAll() {
        return Optional.ofNullable(tramites_cambios_estadosRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tramites_Cambios_Estados> findById(Long id) {
        return tramites_cambios_estadosRepository.findById(id);
    }
    
       @Override
    @Transactional
    public Tramites_Cambios_Estados create(Tramites_Cambios_Estados tramites_cambios_estados) {
        return tramites_cambios_estadosRepository.save(tramites_cambios_estados);
    }

    @Override
    @Transactional
    public Optional<Tramites_Cambios_Estados> update(Tramites_Cambios_Estados tramites_cambios_estados, Long id) {
        if (tramites_cambios_estadosRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tramites_cambios_estadosRepository.save(tramites_cambios_estados));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional
    public void delete(Long id) {

        tramites_cambios_estadosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tramites_cambios_estadosRepository.deleteAll();
    }
}
