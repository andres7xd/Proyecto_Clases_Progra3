/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.Date;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.dto.PermisoOtorgadoDTO;
import org.una.tramites.entities.PermisoOtorgado;
import org.una.tramites.repositories.IPermisoOtorgadoRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class PermisoOtorgadoServiceImplementation implements IPermisoOtorgadoService {

    @Autowired
    private IPermisoOtorgadoRepository permisoOtorgadoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgadoDTO>> findAll() {
        return  (Optional<List<PermisoOtorgadoDTO>>) Convertir.findList(Optional.ofNullable(permisoOtorgadoRepository.findAll()), PermisoOtorgadoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PermisoOtorgadoDTO> findById(Long id) {
        return (Optional<PermisoOtorgadoDTO>) Convertir.oneToDto(permisoOtorgadoRepository.findById(id), PermisoOtorgadoDTO.class);
    }

    @Override
    @Transactional
    public PermisoOtorgadoDTO create(PermisoOtorgadoDTO permisoOtorgadoDTO) {
        PermisoOtorgado permisoOtorgado = MapperUtils.EntityFromDto(permisoOtorgadoDTO, PermisoOtorgado.class);
        permisoOtorgado = permisoOtorgadoRepository.save(permisoOtorgado);
        return MapperUtils.DtoFromEntity(permisoOtorgado, PermisoOtorgadoDTO.class);
    }

    @Override
    @Transactional
    public Optional<PermisoOtorgadoDTO> update(PermisoOtorgadoDTO permisoOtorgadoDTO, Long id) {
        if (permisoOtorgadoRepository.findById(id).isPresent()) {
            PermisoOtorgado permisoOtorgado = MapperUtils.EntityFromDto(permisoOtorgadoDTO, PermisoOtorgado.class);
            permisoOtorgado = permisoOtorgadoRepository.save(permisoOtorgado);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(permisoOtorgado, PermisoOtorgadoDTO.class));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        permisoOtorgadoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        permisoOtorgadoRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgadoDTO>> findByUsuarioId(Long usuarioId) {
        return (Optional<List<PermisoOtorgadoDTO>>) Convertir.findList(Optional.ofNullable(permisoOtorgadoRepository.findByUsuarioId(usuarioId)), PermisoOtorgadoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgadoDTO>> findByPermisoId(Long permisoId) {
       return (Optional<List<PermisoOtorgadoDTO>>) Convertir.findList(Optional.ofNullable(permisoOtorgadoRepository.findByPermisoId(permisoId)),  PermisoOtorgadoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgadoDTO>> findByUsuarioIdAndEstado(Long usuarioId, boolean estado) {
        return (Optional<List<PermisoOtorgadoDTO>>) Convertir.findList(Optional.ofNullable(permisoOtorgadoRepository.findByUsuarioIdAndEstado(usuarioId, estado)),PermisoOtorgadoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgadoDTO>> findByPermisoIdAndEstado(Long permisoId, boolean estado) {
        return (Optional<List<PermisoOtorgadoDTO>>) Convertir.findList(Optional.ofNullable(permisoOtorgadoRepository.findByPermisoIdAndEstado(permisoId, estado)),PermisoOtorgadoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<PermisoOtorgadoDTO>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return  (Optional<List<PermisoOtorgadoDTO>>) Convertir.findList(Optional.ofNullable(permisoOtorgadoRepository.findByFechaRegistroBetween(startDate, endDate)),PermisoOtorgadoDTO.class);
    }
}
