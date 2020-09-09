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
import org.una.tramites.entities.Transaccion;
import org.una.tramites.repositories.ITransaccionRepository;

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
    public Optional<Transaccion> findById(Long id) {
        return transaccionRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByEstadoContaining(Boolean estado) {
        return Optional.ofNullable(transaccionRepository.findByEstadoContaining(estado));
    } 
    @Override
    @Transactional
    public Transaccion create(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    @Override
    @Transactional
    public Optional<Transaccion> update(Transaccion transaccion, Long id) {
        if (transaccionRepository.findById(id).isPresent()) {
            return Optional.ofNullable(transaccionRepository.save(transaccion));
        } else {
            return null;
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByUsuarioIdAndFechaRegistroBetween(Long usuarioId, Date startDate, Date endDate) {
        return Optional.ofNullable(transaccionRepository.findByUsuarioIdAndFechaRegistroBetween(usuarioId, startDate, endDate));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByPermisoIdAndFechaRegistroBetween(Long permisoId, Date startDate, Date endDate) {
        return Optional.ofNullable(transaccionRepository.findByPermisoIdAndFechaRegistroBetween(permisoId, startDate, endDate));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate) {
        return Optional.ofNullable(transaccionRepository.findByObjetoAndFechaRegistroBetween(objeto, startDate, endDate));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return Optional.ofNullable(transaccionRepository.findByFechaRegistroBetween(startDate, endDate));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findAll() {
        return Optional.ofNullable(transaccionRepository.findAll());
    }

}
