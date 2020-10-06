/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.dto.UsuarioDTO;

/**
 *
 * @author andre
 */
public interface IUsuarioService {

    public Optional<List<UsuarioDTO>> findAll();

    public Optional<UsuarioDTO> findById(Long id);

    public Optional<List<UsuarioDTO>> findByCedulaAproximate(String cedula);

    public Optional<List<UsuarioDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto);

    public UsuarioDTO create(UsuarioDTO usuarioDTO);

    public Optional<UsuarioDTO> update(UsuarioDTO usuarioDTO, Long id);

    public Optional<List<UsuarioDTO>> findByDepartamentoId(Long id);

    public Optional<UsuarioDTO> findJefeByDepartamento(Long id);

    public void delete(Long id);

    public void deleteAll();

//    public Optional<UsuarioDTO> login(Usuario usuario);

    public Optional<UsuarioDTO> findByCedula(String cedula);
    
}
