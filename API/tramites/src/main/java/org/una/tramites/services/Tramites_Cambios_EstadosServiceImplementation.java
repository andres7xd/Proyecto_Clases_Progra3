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
import org.una.tramites.dto.Tramites_Cambios_EstadosDTO;
import org.una.tramites.entities.Tramites_Cambios_Estados;
import org.una.tramites.repositories.ITramites_Cambios_EstadosRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

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
    public Optional<List<Tramites_Cambios_EstadosDTO>> findAll() {
        return (Optional<List<Tramites_Cambios_EstadosDTO>>) Convertir.findList(Optional.ofNullable(tramites_cambios_estadosRepository.findAll()), Tramites_Cambios_EstadosDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tramites_Cambios_EstadosDTO> findById(Long id) {
        return (Optional<Tramites_Cambios_EstadosDTO>) Convertir.oneToDto(tramites_cambios_estadosRepository.findById(id), Tramites_Cambios_EstadosDTO.class);
    }

    @Override
    @Transactional
    public Tramites_Cambios_EstadosDTO create(Tramites_Cambios_EstadosDTO tramites_cambios_estadosDTO) {
        Tramites_Cambios_Estados tramites_Cambios_Estados = MapperUtils.EntityFromDto(tramites_cambios_estadosDTO, Tramites_Cambios_Estados.class);
        tramites_Cambios_Estados = tramites_cambios_estadosRepository.save(tramites_Cambios_Estados);
        return MapperUtils.DtoFromEntity(tramites_Cambios_Estados, Tramites_Cambios_EstadosDTO.class);
    }

    @Override
    @Transactional
    public Optional<Tramites_Cambios_EstadosDTO> update(Tramites_Cambios_EstadosDTO tramites_cambios_estadosDTO, Long id) {
        if (tramites_cambios_estadosRepository.findById(id).isPresent()) {
            Tramites_Cambios_Estados tramites_Cambios_Estados = MapperUtils.EntityFromDto(tramites_cambios_estadosDTO, Tramites_Cambios_Estados.class);
            tramites_Cambios_Estados = tramites_cambios_estadosRepository.save(tramites_Cambios_Estados);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tramites_Cambios_Estados, Tramites_Cambios_EstadosDTO.class));
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
