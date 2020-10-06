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
import org.una.tramites.dto.Requisitos_PresentadosDTO;
import org.una.tramites.entities.Requisitos_Presentados;
import org.una.tramites.repositories.IRequisitos_PresentadosRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class Requisitos_PresentadosServiceImplementation implements IRequisitos_PresentadosService {

    @Autowired
    private IRequisitos_PresentadosRepository requisitos_presentadosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Requisitos_PresentadosDTO>> findAll() {
        return (Optional<List<Requisitos_PresentadosDTO>>) Convertir.findList(Optional.ofNullable(requisitos_presentadosRepository.findAll()), Requisitos_PresentadosDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Requisitos_PresentadosDTO> findById(Long id) {
        return (Optional<Requisitos_PresentadosDTO>) Convertir.oneToDto(requisitos_presentadosRepository.findById(id), Requisitos_PresentadosDTO.class);
    }

    @Override
    @Transactional
    public Requisitos_PresentadosDTO create(Requisitos_PresentadosDTO requisitos_presentadosDTO) {
        Requisitos_Presentados requisitos_presentados = MapperUtils.EntityFromDto(requisitos_presentadosDTO, Requisitos_Presentados.class);
        requisitos_presentados = requisitos_presentadosRepository.save(requisitos_presentados);
        return MapperUtils.DtoFromEntity(requisitos_presentados, Requisitos_PresentadosDTO.class);
    }

    @Override
    @Transactional
    public Optional<Requisitos_PresentadosDTO> update(Requisitos_PresentadosDTO requisitos_presentadosDTO, Long id) {
        if (requisitos_presentadosRepository.findById(id).isPresent()) {
            Requisitos_Presentados requisitos_presentados = MapperUtils.EntityFromDto(requisitos_presentadosDTO, Requisitos_Presentados.class);
            requisitos_presentados = requisitos_presentadosRepository.save(requisitos_presentados);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(requisitos_presentados, Requisitos_PresentadosDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        requisitos_presentadosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        
        requisitos_presentadosRepository.deleteAll();
    }
}
