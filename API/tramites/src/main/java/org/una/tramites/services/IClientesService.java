/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Clientes;

/**
 *
 * @author andre
 */
public interface IClientesService {
     public Optional<Clientes> findById(Long id);

    public Clientes create(Clientes clientes);

    public Optional<Clientes> update(Clientes clientes, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<List<Clientes>> findAll();
}
