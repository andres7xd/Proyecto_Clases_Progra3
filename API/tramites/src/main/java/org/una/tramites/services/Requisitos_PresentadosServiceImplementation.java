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
import org.una.tramites.entities.Requisitos_Presentados;
import org.una.tramites.repositories.IRequisitos_PresentadosRepository;

/**
 *
 * @author Luis
 */
@Service
public class Requisitos_PresentadosServiceImplementation implements IRequisitos_PresentadosService{
    
    @Autowired
    private IRequisitos_PresentadosRepository requisitos_presentadosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Requisitos_Presentados>> findAll() {
        return Optional.ofNullable(requisitos_presentadosRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Requisitos_Presentados> findById(Long id) {
        return requisitos_presentadosRepository.findById(id);
    }
    @Override
    @Transactional
    public Requisitos_Presentados create(Requisitos_Presentados requisitos_presentados) {
        return requisitos_presentadosRepository.save(requisitos_presentados);
    }

    @Override
    @Transactional
    public Optional<Requisitos_Presentados> update(Requisitos_Presentados requisitos_presentados, Long id) {
        if (requisitos_presentadosRepository.findById(id).isPresent()) {
            return Optional.ofNullable(requisitos_presentadosRepository.save(requisitos_presentados));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        requisitos_presentadosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        requisitos_presentadosRepository.deleteAll();
    }
}
