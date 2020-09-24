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
import org.una.tramites.dto.Tramites_Cambios_EstadosDTO;
import org.una.tramites.entities.Tramites_Cambios_Estados;
import org.una.tramites.services.ITramites_Cambios_EstadosService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/tramites_cambios_estados") 
@Api(tags = {"Tramites_Cambios_Estados"})
public class Tramites_Cambios_EstadosController {
    
    
    @Autowired
    private ITramites_Cambios_EstadosService tramitescambiosestadosService;
    
    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Tramites Cambios Estados", response = Tramites_Cambios_EstadosDTO.class, responseContainer = "List", tags = "Tramites_Cambios_Estados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Tramites_Cambios_Estados>> result = tramitescambiosestadosService.findAll();
            if (result.isPresent()) {
                List<Tramites_Cambios_EstadosDTO> tramites_cambios_estadossDTO = MapperUtils.DtoListFromEntityList(result.get(), Tramites_Cambios_EstadosDTO.class);
                return new ResponseEntity<>(tramites_cambios_estadossDTO, HttpStatus.OK);
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

            Optional<Tramites_Cambios_Estados> tramites_cambios_estadosFound = tramitescambiosestadosService.findById(id);
            if (tramites_cambios_estadosFound.isPresent()) {
                Tramites_Cambios_EstadosDTO tramites_cambios_estadosDto = MapperUtils.DtoFromEntity(tramites_cambios_estadosFound.get(), Tramites_Cambios_EstadosDTO.class);
                return new ResponseEntity<>(tramites_cambios_estadosDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de Tramites_Cambios_Estados:", response = Tramites_Cambios_EstadosDTO.class, tags = "Tramites_Cambios_Estados")
    public ResponseEntity<?> create(@RequestBody Tramites_Cambios_Estados tramites_cambios_estados) {
        try {
            Tramites_Cambios_Estados tramites_cambios_estadosCreated = tramitescambiosestadosService.create(tramites_cambios_estados);
            Tramites_Cambios_EstadosDTO tramites_cambios_estadosDto = MapperUtils.DtoFromEntity(tramites_cambios_estadosCreated, Tramites_Cambios_EstadosDTO.class);
            return new ResponseEntity<>(tramites_cambios_estadosDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Tramites_Cambios_Estados:", response = Tramites_Cambios_EstadosDTO.class, tags = "Tramites_Cambios_Estados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Tramites_Cambios_Estados tramites_cambios_estadosModified) {
        try {
            Optional<Tramites_Cambios_Estados> tramites_cambios_estadosUpdated = tramitescambiosestadosService.update(tramites_cambios_estadosModified, id);
            if (tramites_cambios_estadosUpdated.isPresent()) {
                Tramites_Cambios_EstadosDTO tramites_cambios_estadosDto = MapperUtils.DtoFromEntity(tramites_cambios_estadosUpdated.get(), Tramites_Cambios_EstadosDTO.class);
                return new ResponseEntity<>(tramites_cambios_estadosDto, HttpStatus.OK);

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
