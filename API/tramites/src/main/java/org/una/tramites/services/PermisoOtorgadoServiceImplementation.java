/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.Date;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Departamento;
import org.una.tramites.entities.PermisoOtorgado;
import org.una.tramites.repositories.IPermisoOtorgadoRepository;

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
    public Optional<PermisoOtorgado> findById(Long id) {
        return permisoOtorgadoRepository.findById(id);
    }

    @Override
    @Transactional
    public PermisoOtorgado create(PermisoOtorgado permisoOtorgado) {
        return permisoOtorgadoRepository.save(permisoOtorgado);
    }

    @Override
    @Transactional
    public Optional<PermisoOtorgado> update(PermisoOtorgado permisoOtorgado, Long id) {
        if (permisoOtorgadoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(permisoOtorgadoRepository.save(permisoOtorgado));
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
    public Optional<List<PermisoOtorgado>> findByUsuarioId(Long usuarioId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<PermisoOtorgado>> findByPermisoId(Long permisoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<PermisoOtorgado>> findByUsuarioIdAndEstado(Long usuarioId, boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<PermisoOtorgado>> findByPermisoIdAndEstado(Long permisoId, boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<PermisoOtorgado>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
