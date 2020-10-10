/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.ClientesDTO;

/**
 *
 * @author andre
 */
public interface IClientesService {
    
    public Optional<ClientesDTO> findById(Long id);

    public ClientesDTO create(ClientesDTO clientesDTO);

    public Optional<ClientesDTO> update(ClientesDTO clientesDTO, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<List<ClientesDTO>> findAll();
    
//     public Optional<List<ClientesDTO>> findByInformacion(String informacion);
}
