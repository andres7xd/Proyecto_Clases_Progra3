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
import org.una.tramites.dto.UsuarioDTO;
import org.una.tramites.entities.Usuario;
import org.una.tramites.repositories.IUsuarioRepository;
import org.una.tramites.utils.Convertir;
import org.una.tramites.utils.MapperUtils;

@Service
public class UsuarioServiceImplementation implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findAll() {
        return (Optional<List<UsuarioDTO>>) Convertir.findList(Optional.ofNullable(usuarioRepository.findAll()), UsuarioDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findById(Long id) {
        return (Optional<UsuarioDTO>) Convertir.oneToDto(usuarioRepository.findById(id), UsuarioDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findByCedulaAproximate(String cedula) {
        return (Optional<List<UsuarioDTO>>) Convertir.findList(usuarioRepository.findByCedulaContaining(cedula), UsuarioDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        return (Optional<List<UsuarioDTO>>) Convertir.findList(usuarioRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto), UsuarioDTO.class);
    }

    @Override
    @Transactional
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        encriptarPassword(usuarioDTO);
        Usuario user = MapperUtils.EntityFromDto(usuarioDTO, Usuario.class);
        user = usuarioRepository.save(user);
        return MapperUtils.DtoFromEntity(user, UsuarioDTO.class);
    }

    @Override
    @Transactional
    public Optional<UsuarioDTO> update(UsuarioDTO usuarioDTO, Long id) {
        if (usuarioRepository.findById(id).isPresent()) {
            Usuario user = MapperUtils.EntityFromDto(usuarioDTO, Usuario.class);
            user = usuarioRepository.save(user);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(user, UsuarioDTO.class));
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

//    @Override
//    @Transactional()
//    public Optional<UsuarioDTO> login(UsuarioDTO usuarioDTO) {
//        return Optional.ofNullable(usuarioRepository.findByCedulaAndPasswordEncriptado(usuarioDTO.getCedula(), usuarioDTO.getPasswordEncriptado()));
//    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findJefeByDepartamento(Long id) {
        Optional<Usuario> result = usuarioRepository.findJefeByDepartamento(id);
        if (result != null) {
            UsuarioDTO usuarioDTO = MapperUtils.DtoFromEntity(result.get(), UsuarioDTO.class);
            return Optional.ofNullable(usuarioDTO);
        } else {
            return null;
        }
    }

//    @Transactional()
//    public UsuarioDTO findByNombreCompleto(String nombreCompleto) {
//        return usuarioRepository.findByNombreCompleto(nombreCompleto);
//    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<UsuarioDTO>> findByDepartamentoId(Long id) {
        return (Optional<List<UsuarioDTO>>) Convertir.findList(usuarioRepository.findByDepartamentoId(id), UsuarioDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioDTO> findByCedula(String cedula) {
        return (Optional<UsuarioDTO>) Convertir.oneToDto(Optional.ofNullable(usuarioRepository.findByCedula(cedula)), UsuarioDTO.class);
    }

    private void encriptarPassword(UsuarioDTO usuarioDTO) {
        String password = usuarioDTO.getPasswordEncriptado();
        if (!password.isBlank()) {
            usuarioDTO.setPasswordEncriptado(bCryptPasswordEncoder.encode(password));
        }
    }

}
