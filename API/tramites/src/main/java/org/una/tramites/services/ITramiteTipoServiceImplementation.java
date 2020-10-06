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
import org.una.tramites.dto.TramiteTipoDTO;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.repositories.ITramiteTipoRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;



/**
 *
 * @author andre
 */
@Service
public class ITramiteTipoServiceImplementation implements ITramiteTipoService {
     @Autowired
    private ITramiteTipoRepository tramiteTipoRepository;
   
    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipoDTO>> findAll() {
        return (Optional<List<TramiteTipoDTO>>) Convertir.findList(Optional.ofNullable(tramiteTipoRepository.findAll()), TramiteTipoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TramiteTipoDTO> findById(Long id) {
        return (Optional<TramiteTipoDTO>) Convertir.oneToDto(tramiteTipoRepository.findById(id), TramiteTipoDTO.class);
    }

    @Override
    @Transactional
    public TramiteTipoDTO create(TramiteTipoDTO tramiteTipoDTO) {
        TramiteTipo tramiteTipo = MapperUtils.EntityFromDto(tramiteTipoDTO, TramiteTipo.class);
        tramiteTipo = tramiteTipoRepository.save(tramiteTipo);
        return MapperUtils.DtoFromEntity(tramiteTipo, TramiteTipoDTO.class);
    }

    @Override
    @Transactional
    public Optional<TramiteTipoDTO> update(TramiteTipoDTO tramiteTipoDTO, Long id) {
        if (tramiteTipoRepository.findById(id).isPresent()) {
            TramiteTipo tramiteTipo = MapperUtils.EntityFromDto(tramiteTipoDTO, TramiteTipo.class);
            tramiteTipo = tramiteTipoRepository.save(tramiteTipo);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tramiteTipo, TramiteTipoDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tramiteTipoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tramiteTipoRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipoDTO>> findByDepartamentoId(Long id) {
        return (Optional<List<TramiteTipoDTO>>) Convertir.findList(tramiteTipoRepository.findByDepartamentoId(id), TramiteTipoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipoDTO>> findByDescripcion(String descripcion) {
        return (Optional<List<TramiteTipoDTO>>) Convertir.findList(Optional.ofNullable(tramiteTipoRepository.findByDescripcion(descripcion)), TramiteTipoDTO.class);
    }

}
