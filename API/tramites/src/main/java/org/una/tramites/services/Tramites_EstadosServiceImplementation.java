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
import org.una.tramites.dto.Tramites_EstadosDTO;
import org.una.tramites.entities.Tramites_Estados;
import org.una.tramites.repositories.ITramites_EstadosRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

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
    public Optional<List<Tramites_EstadosDTO>> findAll() {
        return (Optional<List<Tramites_EstadosDTO>>) Convertir.findList(Optional.ofNullable(tramites_estadosRepository.findAll()), Tramites_EstadosDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tramites_EstadosDTO> findById(Long id) {
        return (Optional<Tramites_EstadosDTO>) Convertir.oneToDto(tramites_estadosRepository.findById(id), Tramites_EstadosDTO.class);
    }
    
    @Override
    @Transactional
    public Tramites_EstadosDTO create(Tramites_EstadosDTO tramites_estadosDTO) {
        Tramites_Estados tramites_Estados = MapperUtils.EntityFromDto(tramites_estadosDTO, Tramites_Estados.class);
        tramites_Estados = tramites_estadosRepository.save(tramites_Estados);
        return MapperUtils.DtoFromEntity(tramites_Estados, Tramites_EstadosDTO.class);
    }

    @Override
    @Transactional
    public Optional<Tramites_EstadosDTO> update(Tramites_EstadosDTO tramites_estadosDTO, Long id) {
        
        if (tramites_estadosRepository.findById(id).isPresent()) {
            Tramites_Estados tramites_Estados = MapperUtils.EntityFromDto(tramites_estadosDTO, Tramites_Estados.class);
            tramites_Estados = tramites_estadosRepository.save(tramites_Estados);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tramites_Estados, Tramites_EstadosDTO.class));
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
