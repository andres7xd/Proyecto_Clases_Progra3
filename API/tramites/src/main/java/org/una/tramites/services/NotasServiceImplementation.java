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
import org.una.tramites.dto.NotasDTO;
import org.una.tramites.entities.Notas;
import org.una.tramites.repositories.INotasRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class NotasServiceImplementation implements INotasService{
    
    @Autowired
    private INotasRepository notasRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<NotasDTO>> findAll() {
       return (Optional<List<NotasDTO>>) Convertir.findList(Optional.ofNullable(notasRepository.findAll()), NotasDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NotasDTO> findById(Long id) {
        return (Optional<NotasDTO>) Convertir.oneToDto(notasRepository.findById(id), NotasDTO.class);
    }
    
    @Override
    @Transactional
    public NotasDTO create(NotasDTO notasDTO) {
        Notas notas = MapperUtils.EntityFromDto(notasDTO, Notas.class);
        notas = notasRepository.save(notas);
        return MapperUtils.DtoFromEntity(notas, NotasDTO.class);
    }

    @Override
    @Transactional
    public Optional<NotasDTO> update(NotasDTO notasDTO, Long id) {
       if (notasRepository.findById(id).isPresent()) {
            Notas notas = MapperUtils.EntityFromDto(notasDTO, Notas.class);
            notas = notasRepository.save(notas);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(notas, NotasDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        notasRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        notasRepository.deleteAll();
    }

}
