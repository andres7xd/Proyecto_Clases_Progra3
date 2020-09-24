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
import org.una.tramites.entities.Parametros_Generales;
import org.una.tramites.repositories.IParametros_GeneralesRepository;

/**
 *
 * @author andre
 */
@Service
public class IParametros_GeneralesServiceImplementation implements IParametros_GeneralesService{
    
    @Autowired
    private IParametros_GeneralesRepository parametros_generalesRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Parametros_Generales>> findAll() {
        return Optional.ofNullable(parametros_generalesRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Parametros_Generales> findById(Long id) {
        return parametros_generalesRepository.findById(id);
    }
    
       @Override
    @Transactional
    public Parametros_Generales create(Parametros_Generales parametros_generales) {
        return parametros_generalesRepository.save(parametros_generales);
    }

    @Override
    @Transactional
    public Optional<Parametros_Generales> update(Parametros_Generales parametros_generales, Long id) {
        if (parametros_generalesRepository.findById(id).isPresent()) {
            return Optional.ofNullable(parametros_generalesRepository.save(parametros_generales));
        } else {
            return null;
        }
    }
    
    @Override
    @Transactional
    public void delete(Long id) {

        parametros_generalesRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        parametros_generalesRepository.deleteAll();
    }
    
}
