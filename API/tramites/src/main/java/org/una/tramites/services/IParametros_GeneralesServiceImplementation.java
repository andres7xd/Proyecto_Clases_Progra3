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
import org.una.tramites.dto.Parametros_GeneralesDTO;
import org.una.tramites.entities.Parametros_Generales;
import org.una.tramites.repositories.IParametros_GeneralesRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

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
    public Optional<List<Parametros_GeneralesDTO>> findAll() {
        return (Optional<List<Parametros_GeneralesDTO>>) Convertir.findList(Optional.ofNullable(parametros_generalesRepository.findAll()), Parametros_GeneralesDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Parametros_GeneralesDTO> findById(Long id) {
        return (Optional<Parametros_GeneralesDTO>) Convertir.oneToDto(parametros_generalesRepository.findById(id), Parametros_GeneralesDTO.class);
    }
    
       @Override
    @Transactional
    public Parametros_GeneralesDTO create(Parametros_GeneralesDTO parametros_generalesDTO) {
        Parametros_Generales parametros_generales = MapperUtils.EntityFromDto(parametros_generalesDTO, Parametros_Generales.class);
        parametros_generales = parametros_generalesRepository.save(parametros_generales);
        return MapperUtils.DtoFromEntity(parametros_generales, Parametros_GeneralesDTO.class);
    }

    @Override
    @Transactional
    public Optional<Parametros_GeneralesDTO> update(Parametros_GeneralesDTO parametros_generalesDTO, Long id) {
        if (parametros_generalesRepository.findById(id).isPresent()) {
            Parametros_Generales parametros_generales = MapperUtils.EntityFromDto(parametros_generalesDTO, Parametros_Generales.class);
            parametros_generales = parametros_generalesRepository.save(parametros_generales);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(parametros_generales, Parametros_GeneralesDTO.class));
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
