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
import org.una.tramites.dto.Archivos_RelacionadosDTO;
import org.una.tramites.entities.Archivos_Relacionados;
import org.una.tramites.repositories.IArchivos_RelacionadosRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class Archivos_RelacionadosServiceImplementation implements IArchivos_RelacionadosService{
    @Autowired
    private IArchivos_RelacionadosRepository archivos_relacionadosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Archivos_RelacionadosDTO>> findAll() {
         return  (Optional<List<Archivos_RelacionadosDTO>>) Convertir.findList(Optional.ofNullable(archivos_relacionadosRepository.findAll()), Archivos_RelacionadosDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Archivos_RelacionadosDTO> findById(Long id) {
        return (Optional<Archivos_RelacionadosDTO>) Convertir.oneToDto(archivos_relacionadosRepository.findById(id), Archivos_RelacionadosDTO.class);
    }
    @Override
    @Transactional
    public Archivos_RelacionadosDTO create(Archivos_RelacionadosDTO archivos_relacionadosDTO) {
        Archivos_Relacionados archivos_relacionados = MapperUtils.EntityFromDto(archivos_relacionadosDTO, Archivos_Relacionados.class);
        archivos_relacionados = archivos_relacionadosRepository.save(archivos_relacionados);
        return MapperUtils.DtoFromEntity(archivos_relacionados, Archivos_RelacionadosDTO.class);
    }

    @Override
    @Transactional
    public Optional<Archivos_RelacionadosDTO> update(Archivos_RelacionadosDTO archivos_relacionadosDTO, Long id) {
        if (archivos_relacionadosRepository.findById(id).isPresent()) {
            Archivos_Relacionados archivos_relacionados = MapperUtils.EntityFromDto(archivos_relacionadosDTO, Archivos_Relacionados.class);
            archivos_relacionados = archivos_relacionadosRepository.save(archivos_relacionados);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(archivos_relacionados, Archivos_RelacionadosDTO.class));
        } else {
            return null;
        }


    }

    @Override
    @Transactional
    public void delete(Long id) {

        archivos_relacionadosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        archivos_relacionadosRepository.deleteAll();
    }

}
