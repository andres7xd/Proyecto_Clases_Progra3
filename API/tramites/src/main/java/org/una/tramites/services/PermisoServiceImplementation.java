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
import org.una.tramites.dto.PermisoDTO;
import org.una.tramites.entities.Permiso;
import org.una.tramites.repositories.IPermisoRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class PermisoServiceImplementation implements IPermisoService {

    @Autowired
    private IPermisoRepository permisoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoDTO>> findAll() {
        return  (Optional<List<PermisoDTO>>) Convertir.findList(Optional.ofNullable(permisoRepository.findAll()), PermisoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PermisoDTO> findById(Long id) {
        return (Optional<PermisoDTO>) Convertir.oneToDto(permisoRepository.findById(id), PermisoDTO.class);
    }

    @Transactional(readOnly = true)
    public Optional<List<PermisoDTO>> findByEstado(boolean estado) {
        return (Optional<List<PermisoDTO>>) Convertir.findList(permisoRepository.findByEstadoContaining(estado), PermisoDTO.class);
    }

    @Override
    @Transactional
    public PermisoDTO create(PermisoDTO permisoDTO) {
        Permiso permiso = MapperUtils.EntityFromDto(permisoDTO, Permiso.class);
        permiso = permisoRepository.save(permiso);
        return MapperUtils.DtoFromEntity(permiso, PermisoDTO.class);
    }

    @Override
    @Transactional
    public Optional<PermisoDTO> update(PermisoDTO permisoDTO, Long id) {
        if (permisoRepository.findById(id).isPresent()) {
            Permiso permiso = MapperUtils.EntityFromDto(permisoDTO, Permiso.class);
            permiso = permisoRepository.save(permiso);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(permiso, PermisoDTO.class));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        permisoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        permisoRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PermisoDTO> findByCodigo(String codigo) {
        return (Optional<PermisoDTO>) Convertir.oneToDto(Optional.ofNullable(permisoRepository.findByCodigo(codigo)), PermisoDTO.class);
    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<List<Permiso>> findByCodigoAproximate(String codigo) {
//        return Optional.ofNullable(permisoRepository.findByCodigoAproximate(codigo));
//    }

}
