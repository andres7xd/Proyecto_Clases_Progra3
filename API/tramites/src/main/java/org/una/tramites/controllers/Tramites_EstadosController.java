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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.una.tramites.dto.Tramites_EstadosDTO;
import org.una.tramites.entities.Tramites_Estados;
import org.una.tramites.services.ITramites_EstadosService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@RestController
@RequestMapping("/tramites_estados") 
@Api(tags = {"Tramites_Estados"})

public class Tramites_EstadosController {
    
    @Autowired
    private ITramites_EstadosService tramites_estadosService;

    @GetMapping() 
    @ApiOperation(value = "Obtiene una lista de todos los tramites_estados", response = Tramites_EstadosDTO.class, responseContainer = "List", tags = "Tramites_Estados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Tramites_Estados>> result = tramites_estadosService.findAll();
            if (result.isPresent()) {
                List<Tramites_EstadosDTO> tramites_estadosDTO = MapperUtils.DtoListFromEntityList(result.get(), Tramites_EstadosDTO.class);
                return new ResponseEntity<>(tramites_estadosDTO, HttpStatus.OK);
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

            Optional<Tramites_Estados> tramites_estadosFound = tramites_estadosService.findById(id);
            if (tramites_estadosFound.isPresent()) {
                Tramites_EstadosDTO tramites_estadosDto = MapperUtils.DtoFromEntity(tramites_estadosFound.get(), Tramites_EstadosDTO.class);
                return new ResponseEntity<>(tramites_estadosDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de un tramite_estado:", response = Tramites_EstadosDTO.class, tags = "Tramites_Estados")
    public ResponseEntity<?> create(@RequestBody Tramites_Estados tramites_estados) {
        try {
            Tramites_Estados tramites_estadosCreated = tramites_estadosService.create(tramites_estados);
            Tramites_EstadosDTO tramites_estadosDto = MapperUtils.DtoFromEntity(tramites_estadosCreated, Tramites_EstadosDTO.class);
            return new ResponseEntity<>(tramites_estadosDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}") 
    @ResponseBody
    @ApiOperation(value = "Actualizacion de tramites_estado:", response = Tramites_EstadosDTO.class, tags = "Tramites_Estados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Tramites_Estados tramites_estadosModified) {
        try {
            Optional<Tramites_Estados> tramites_estadosUpdated = tramites_estadosService.update(tramites_estadosModified, id);
            if (tramites_estadosUpdated.isPresent()) {
                Tramites_EstadosDTO tramites_estadosDto = MapperUtils.DtoFromEntity(tramites_estadosUpdated.get(), Tramites_EstadosDTO.class);
                return new ResponseEntity<>(tramites_estadosDto, HttpStatus.OK);

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
