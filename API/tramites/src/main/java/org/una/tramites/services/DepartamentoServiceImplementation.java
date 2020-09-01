/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Departamento;
import org.una.tramites.repositories.IDepartamentoRepository;

/**
 *
 * @author Luis
 */
public class DepartamentoServiceImplementation implements IDepartamentoService{
    
    @Autowired
    private IDepartamentoRepository departamentoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Departamento>> findAll() {
        return Optional.ofNullable(departamentoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }
    
    /*@Override
    @Transactional(readOnly = true)
    public Optional<List<Departamento>> findByEstadoContaining(Boolean estado) {
        return Optional.ofNullable(departamentoRepository.findByEstadoContaining(estado));
    }*/

    @Override
    @Transactional
    public Departamento create(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }
    
     @Override
    @Transactional
    public Optional<Departamento> update(Departamento departamento, Long id) {
        if (departamentoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(departamentoRepository.save(departamento));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        departamentoRepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public void deleteAll() {
        departamentoRepository.deleteAll();
    }

}
