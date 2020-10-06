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
import org.una.tramites.dto.VariacionDTO;
import org.una.tramites.entities.Variacion;
import org.una.tramites.repositories.IVariacionRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author andre
 */
@Service
public class IVariacionServiceImplementation implements IVariacionService {
    @Autowired
    private IVariacionRepository variacionRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<VariacionDTO>> findAll() {
        return (Optional<List<VariacionDTO>>) Convertir.findList(Optional.ofNullable(variacionRepository.findAll()), VariacionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VariacionDTO> findById(Long id) {
        return (Optional<VariacionDTO>) Convertir.oneToDto(variacionRepository.findById(id), VariacionDTO.class);
    }

    @Override
    @Transactional
    public VariacionDTO create(VariacionDTO variacionDTO) {
        Variacion variacion = MapperUtils.EntityFromDto(variacionDTO, Variacion.class);
        variacion = variacionRepository.save(variacion);
        return MapperUtils.DtoFromEntity(variacion, VariacionDTO.class);
    }

    @Override
    @Transactional
    public Optional<VariacionDTO> update(VariacionDTO variacionDTO, Long id) {
        if (variacionRepository.findById(id).isPresent()) {
            Variacion variacion = MapperUtils.EntityFromDto(variacionDTO, Variacion.class);
            variacion = variacionRepository.save(variacion);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(variacion, VariacionDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        variacionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        variacionRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<VariacionDTO>> findByGrupo(String grupo) {
        return (Optional<List<VariacionDTO>>) Convertir.findList(Optional.ofNullable(variacionRepository.findByGrupo(grupo)), VariacionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<VariacionDTO>> findByDescripcion(String descripcion) {
        return (Optional<List<VariacionDTO>>) Convertir.findList(Optional.ofNullable(variacionRepository.findByDescripcion(descripcion)), VariacionDTO.class);
    }
}
