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
import org.una.tramites.dto.TransaccionDTO;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.repositories.ITransaccionRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author rache
 */
@Service
public class TransaccionServiceImplementation implements ITransaccionService {

    @Autowired
    private ITransaccionRepository transaccionRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<TransaccionDTO> findById(Long id) {
        return (Optional<TransaccionDTO>) Convertir.oneToDto(transaccionRepository.findById(id), TransaccionDTO.class);
    }

    @Transactional(readOnly = true)
    public Optional<List<TransaccionDTO>> findByEstadoContaining(Boolean estado) {
        return (Optional<List<TransaccionDTO>>) Convertir.findList(Optional.ofNullable(transaccionRepository.findByEstadoContaining(estado)), TransaccionDTO.class);
    }

    @Override
    @Transactional
    public TransaccionDTO create(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = MapperUtils.EntityFromDto(transaccionDTO, Transaccion.class);
        transaccion = transaccionRepository.save(transaccion);
        return MapperUtils.DtoFromEntity(transaccion, TransaccionDTO.class);
    }

    @Override
    @Transactional
    public Optional<TransaccionDTO> update(TransaccionDTO transaccionDTO, Long id) {
        if (transaccionRepository.findById(id).isPresent()) {
            Transaccion transaccion = MapperUtils.EntityFromDto(transaccionDTO, Transaccion.class);
            transaccion = transaccionRepository.save(transaccion);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(transaccion, TransaccionDTO.class));
        } else {
            return null;
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TransaccionDTO>> findByUsuarioIdAndFechaRegistroBetween(Long usuarioId, Date startDate, Date endDate) {
        return (Optional<List<TransaccionDTO>>) Convertir.findList(Optional.ofNullable(transaccionRepository.findByUsuarioIdAndFechaRegistroBetween(usuarioId, startDate, endDate)), TransaccionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TransaccionDTO>> findByPermisoIdAndFechaRegistroBetween(Long permisoId, Date startDate, Date endDate) {
        return (Optional<List<TransaccionDTO>>) Convertir.findList(Optional.ofNullable(transaccionRepository.findByPermisoIdAndFechaRegistroBetween(permisoId, startDate, endDate)), TransaccionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TransaccionDTO>> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate) {
        return (Optional<List<TransaccionDTO>>) Convertir.findList(Optional.ofNullable(transaccionRepository.findByObjetoAndFechaRegistroBetween(objeto, startDate, endDate)), TransaccionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TransaccionDTO>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return (Optional<List<TransaccionDTO>>) Convertir.findList(Optional.ofNullable(transaccionRepository.findByFechaRegistroBetween(startDate, endDate)), TransaccionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TransaccionDTO>> findAll() {
        return (Optional<List<TransaccionDTO>>) Convertir.findList(Optional.ofNullable(transaccionRepository.findAll()), TransaccionDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        transaccionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        transaccionRepository.deleteAll();
    }
    }
