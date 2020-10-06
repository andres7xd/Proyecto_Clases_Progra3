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
import org.una.tramites.dto.RequisitoDTO;
import org.una.tramites.entities.Requisito;
import org.una.tramites.repositories.IRequisitoRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author andre
 */
@Service
public class RequisitoServiceImplementation implements IRequisitoService {
    @Autowired
    private IRequisitoRepository requisitoRepository;
    
    @Override
    public Optional<List<RequisitoDTO>> findAll() {
        return (Optional<List<RequisitoDTO>>) Convertir.findList(Optional.ofNullable(requisitoRepository.findAll()), RequisitoDTO.class);
    }

    @Override
    public Optional<RequisitoDTO> findById(Long id) {
        return (Optional<RequisitoDTO>) Convertir.oneToDto(requisitoRepository.findById(id), RequisitoDTO.class);
    }

    @Override
    public RequisitoDTO create(RequisitoDTO requisitoDTO) {
        Requisito requisito = MapperUtils.EntityFromDto(requisitoDTO, Requisito.class);
        requisito = requisitoRepository.save(requisito);
        return MapperUtils.DtoFromEntity(requisito, RequisitoDTO.class);
    }

    
    @Override
    @Transactional
    public Optional<RequisitoDTO> update(RequisitoDTO requisitoDTO, Long id) {
        if (requisitoRepository.findById(id).isPresent()) {
            Requisito requisito = MapperUtils.EntityFromDto(requisitoDTO, Requisito.class);
            requisito = requisitoRepository.save(requisito);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(requisito, RequisitoDTO.class));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        requisitoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        requisitoRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<RequisitoDTO>> findByDescripcion(String descripcion) {
        return (Optional<List<RequisitoDTO>>) Convertir.findList(Optional.ofNullable(requisitoRepository.findByDescripcion(descripcion)), RequisitoDTO.class);
    }
}
