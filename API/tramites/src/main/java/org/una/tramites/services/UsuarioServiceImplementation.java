/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Usuario;
import org.una.tramites.repositories.IUsuarioRepository;

@Service
public class UsuarioServiceImplementation implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findAll() {
        return Optional.ofNullable(usuarioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findByCedulaAproximate(String cedula) {
        return Optional.ofNullable(usuarioRepository.findByCedulaContaining(cedula));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        return Optional.ofNullable(usuarioRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto));
    }

    @Override
    @Transactional
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Optional<Usuario> update(Usuario usuario, Long id) {
        if (usuarioRepository.findById(id).isPresent()) {
            return Optional.ofNullable(usuarioRepository.save(usuario));
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void delete(Long id) {

        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        usuarioRepository.deleteAll();
    }

    @Override
    @Transactional()
    public Optional<Usuario> login(Usuario usuario) {
        return Optional.ofNullable(usuarioRepository.findByCedulaAndPasswordEncriptado(usuario.getCedula(), usuario.getPasswordEncriptado()));
    }

    @Override
    public Usuario findJefeByDepartamento(Long id) {
        return usuarioRepository.findJefeByDepartamento(id);
    }
    
    public Usuario findByNombreCompleto(String nombreCompleto){
         return usuarioRepository.findByNombreCompleto(nombreCompleto);
    } 

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Usuario>> findByDepartamentoId(Long id) {
        return Optional.ofNullable(usuarioRepository.findByDepartamentoId(id));
    }
}

