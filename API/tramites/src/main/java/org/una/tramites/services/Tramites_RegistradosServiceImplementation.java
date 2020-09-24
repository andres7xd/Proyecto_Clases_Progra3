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
import org.una.tramites.entities.Tramites_Registrados;
import org.una.tramites.repositories.ITramites_RegistradosRepository;

/**
 *
 * @author Luis
 */
@Service
public class Tramites_RegistradosServiceImplementation implements ITramites_RegistradosService{
    
    @Autowired
    private ITramites_RegistradosRepository tramites_registradosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Tramites_Registrados>> findAll() {
        return Optional.ofNullable(tramites_registradosRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tramites_Registrados> findById(Long id) {
        return tramites_registradosRepository.findById(id);
    }
    @Override
    @Transactional
    public Tramites_Registrados create(Tramites_Registrados tramites_registrados) {
        return tramites_registradosRepository.save(tramites_registrados);
    }

    @Override
    @Transactional
    public Optional<Tramites_Registrados> update(Tramites_Registrados tramites_registrados, Long id) {
        if (tramites_registradosRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tramites_registradosRepository.save(tramites_registrados));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        tramites_registradosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tramites_registradosRepository.deleteAll();
    }
}
