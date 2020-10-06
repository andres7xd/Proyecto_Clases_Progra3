/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.dto.ClientesDTO;
import org.una.tramites.entities.Clientes;
import org.una.tramites.repositories.IClientesRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author andre
 */
@Service
public class IClientesServiceImplementation implements IClientesService {

    @Autowired
    private IClientesRepository clientesRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClientesDTO>> findAll() {
        return (Optional<List<ClientesDTO>>) Convertir.findList(Optional.ofNullable(clientesRepository.findAll()), ClientesDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientesDTO> findById(Long id) {
        return (Optional<ClientesDTO>) Convertir.oneToDto(clientesRepository.findById(id), ClientesDTO.class);
    }

    @Override
    @Transactional
    public ClientesDTO create(ClientesDTO clientesDTO) {
        encriptarPassword(clientesDTO);
        Clientes clientes = MapperUtils.EntityFromDto(clientesDTO, Clientes.class);
        clientes = clientesRepository.save(clientes);
        return MapperUtils.DtoFromEntity(clientes, ClientesDTO.class);
    }

    @Override
    @Transactional
    public Optional<ClientesDTO> update(ClientesDTO clientesDTO, Long id) {
        if (clientesRepository.findById(id).isPresent()) {
            Clientes clientes = MapperUtils.EntityFromDto(clientesDTO, Clientes.class);
            clientes = clientesRepository.save(clientes);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(clientes, ClientesDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        clientesRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        clientesRepository.deleteAll();
    }

    private void encriptarPassword(ClientesDTO clientesDTO) {
        String password = clientesDTO.getPasswordEncriptado();
        if (!password.isBlank()) {
            clientesDTO.setPasswordEncriptado(bCryptPasswordEncoder.encode(password));
        }
    }
}
