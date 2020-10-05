/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.AuthenticationRequest;
import org.una.tramites.dto.AuthenticationResponse;
import org.una.tramites.dto.UsuarioDTO;
import org.una.tramites.entities.Usuario;
import org.una.tramites.services.IUsuarioService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/usuarios")
@Api(tags = {"Usuarios"})
   
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Usuarios", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Usuario>> result = usuarioService.findAll();
            if (result.isPresent()) {
                List<UsuarioDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Usuario> usuarioFound = usuarioService.findById(id);
            if (usuarioFound.isPresent()) {
                UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioFound.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cedula/{term}")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "term") String term) {
        try {
            Optional<List<Usuario>> result = usuarioService.findByCedulaAproximate(term);
            if (result.isPresent()) {
                List<UsuarioDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nombre/{term}")
    public ResponseEntity<?> findByNombreCompletoAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        try {
            Optional<List<Usuario>> result = usuarioService.findByNombreCompletoAproximateIgnoreCase(term);
            if (result.isPresent()) {
                List<UsuarioDTO> usuariosDTO = MapperUtils.DtoListFromEntityList(result.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Creacion de Usuario:", response = UsuarioDTO.class, tags = "Mantenimiento")
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioCreated = usuarioService.create(usuario);
            UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioCreated, UsuarioDTO.class);
            return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Usuario:", response = UsuarioDTO.class, tags = "Mantenimiento")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Usuario usuarioModified) {
        try {
            Optional<Usuario> usuarioUpdated = usuarioService.update(usuarioModified, id);
            if (usuarioUpdated.isPresent()) {
                UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuarioUpdated.get(), UsuarioDTO.class);
                return new ResponseEntity<>(usuarioDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        return null;

    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() {
        return null;

    }
}
