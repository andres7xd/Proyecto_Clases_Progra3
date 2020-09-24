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
import org.una.tramites.entities.Clientes;
import org.una.tramites.repositories.IClientesRepository;

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
    public Optional<List<Clientes>> findAll() {
        return Optional.ofNullable(clientesRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clientes> findById(Long id) {
        return clientesRepository.findById(id);
    }
    
       @Override
    @Transactional
    public Clientes create(Clientes clientes) {
        encriptarPassword(clientes);
        return clientesRepository.save(clientes);
    }

    @Override
    @Transactional
    public Optional<Clientes> update(Clientes clientes, Long id) {
        if (clientesRepository.findById(id).isPresent()) {
            return Optional.ofNullable(clientesRepository.save(clientes));
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
    
    
      private void encriptarPassword(Clientes clientes) {
        String password = clientes.getPasswordEncriptado();
        if (!password.isBlank()) {
            clientes.setPasswordEncriptado(bCryptPasswordEncoder.encode(password));
        }
    }
}
