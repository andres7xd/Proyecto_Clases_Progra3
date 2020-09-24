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
import org.una.tramites.entities.Tramites_Estados;
import org.una.tramites.repositories.ITramites_EstadosRepository;

/**
 *
 * @author Luis
 */
@Service
public class Tramites_EstadosServiceImplementation implements ITramites_EstadosService{
    
    @Autowired
    private ITramites_EstadosRepository tramites_estadosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Tramites_Estados>> findAll() {
        return Optional.ofNullable(tramites_estadosRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tramites_Estados> findById(Long id) {
        return tramites_estadosRepository.findById(id);
    }
    @Override
    @Transactional
    public Tramites_Estados create(Tramites_Estados tramites_estados) {
        return tramites_estadosRepository.save(tramites_estados);
    }

    @Override
    @Transactional
    public Optional<Tramites_Estados> update(Tramites_Estados tramites_estados, Long id) {
        if (tramites_estadosRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tramites_estadosRepository.save(tramites_estados));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        tramites_estadosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tramites_estadosRepository.deleteAll();
    }
}
