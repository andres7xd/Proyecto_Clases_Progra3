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
import org.una.tramites.dto.DepartamentoDTO;
import org.una.tramites.entities.Departamento;
import org.una.tramites.repositories.IDepartamentoRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class DepartamentoServiceImplementation implements IDepartamentoService {

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<DepartamentoDTO>> findAll() {
       return  (Optional<List<DepartamentoDTO>>) Convertir.findList(Optional.ofNullable(departamentoRepository.findAll()), DepartamentoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DepartamentoDTO> findById(Long id) {
       return (Optional<DepartamentoDTO>) Convertir.oneToDto(departamentoRepository.findById(id), DepartamentoDTO.class);
    }
    @Override
    @Transactional
    public DepartamentoDTO create(DepartamentoDTO departamentoDTO) {
        Departamento departamento = MapperUtils.EntityFromDto(departamentoDTO, Departamento.class);
        departamento = departamentoRepository.save(departamento);
        return MapperUtils.DtoFromEntity(departamento, DepartamentoDTO.class);
    }

    @Override
    @Transactional
    public Optional<DepartamentoDTO> update(DepartamentoDTO departamentoDTO, Long id) {
        if (departamentoRepository.findById(id).isPresent()) {
            Departamento departamento = MapperUtils.EntityFromDto(departamentoDTO, Departamento.class);
            departamento = departamentoRepository.save(departamento);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(departamento, DepartamentoDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        departamentoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        departamentoRepository.deleteAll();
    }

}
