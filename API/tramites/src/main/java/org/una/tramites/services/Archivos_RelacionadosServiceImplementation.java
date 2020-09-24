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
import org.una.tramites.entities.Archivos_Relacionados;
import org.una.tramites.repositories.IArchivos_RelacionadosRepository;

/**
 *
 * @author Luis
 */
@Service
public class Archivos_RelacionadosServiceImplementation implements IArchivos_RelacionadosService{
    @Autowired
    private IArchivos_RelacionadosRepository archivos_relacionadosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Archivos_Relacionados>> findAll() {
        return Optional.ofNullable(archivos_relacionadosRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Archivos_Relacionados> findById(Long id) {
        return archivos_relacionadosRepository.findById(id);
    }
    @Override
    @Transactional
    public Archivos_Relacionados create(Archivos_Relacionados archivos_relacionados) {
        return archivos_relacionadosRepository.save(archivos_relacionados);
    }

    @Override
    @Transactional
    public Optional<Archivos_Relacionados> update(Archivos_Relacionados archivos_relacionados, Long id) {
        if (archivos_relacionadosRepository.findById(id).isPresent()) {
            return Optional.ofNullable(archivos_relacionadosRepository.save(archivos_relacionados));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        archivos_relacionadosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        archivos_relacionadosRepository.deleteAll();
    }

}
