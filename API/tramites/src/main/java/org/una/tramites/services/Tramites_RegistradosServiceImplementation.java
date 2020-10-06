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
import org.una.tramites.dto.Tramites_RegistradosDTO;
import org.una.tramites.entities.Tramites_Registrados;
import org.una.tramites.repositories.ITramites_RegistradosRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class Tramites_RegistradosServiceImplementation implements ITramites_RegistradosService{
    
    @Autowired
    private ITramites_RegistradosRepository tramites_registradosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Tramites_RegistradosDTO>> findAll() {
        return (Optional<List<Tramites_RegistradosDTO>>) Convertir.findList(Optional.ofNullable(tramites_registradosRepository.findAll()), Tramites_RegistradosDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tramites_RegistradosDTO> findById(Long id) {
        return (Optional<Tramites_RegistradosDTO>) Convertir.oneToDto(tramites_registradosRepository.findById(id), Tramites_RegistradosDTO.class);
    }
    
    @Override
    @Transactional
    public Tramites_RegistradosDTO create(Tramites_RegistradosDTO tramites_registradosDTO) {
        Tramites_Registrados tramites_Registrados = MapperUtils.EntityFromDto(tramites_registradosDTO, Tramites_Registrados.class);
        tramites_Registrados = tramites_registradosRepository.save(tramites_Registrados);
        return MapperUtils.DtoFromEntity(tramites_Registrados, Tramites_RegistradosDTO.class);
    }

    @Override
    @Transactional
    public Optional<Tramites_RegistradosDTO> update(Tramites_RegistradosDTO tramites_registradosDTO, Long id) {
        if (tramites_registradosRepository.findById(id).isPresent()) {
            Tramites_Registrados tramites_Registrados = MapperUtils.EntityFromDto(tramites_registradosDTO, Tramites_Registrados.class);
            tramites_Registrados = tramites_registradosRepository.save(tramites_Registrados);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tramites_Registrados, Tramites_RegistradosDTO.class));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        tramites_registradosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tramites_registradosRepository.deleteAll();
    }
}
