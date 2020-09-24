/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.una.tramites.dto.Parametros_GeneralesDTO;
import org.una.tramites.entities.Parametros_Generales;
import org.una.tramites.services.IParametros_GeneralesService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author andre
 */
public class Parametros_GeneralesController {

    @Autowired
    private IParametros_GeneralesService parametrosgeneralesService;
    
    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Parametros Generales", response = Parametros_GeneralesDTO.class, responseContainer = "List", tags = "Parametros_Generales")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Parametros_Generales>> result = parametrosgeneralesService.findAll();
            if (result.isPresent()) {
                List<Parametros_GeneralesDTO> parametros_generalessDTO = MapperUtils.DtoListFromEntityList(result.get(), Parametros_GeneralesDTO.class);
                return new ResponseEntity<>(parametros_generalessDTO, HttpStatus.OK);
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

            Optional<Parametros_Generales> parametros_generalesFound = parametrosgeneralesService.findById(id);
            if (parametros_generalesFound.isPresent()) {
                Parametros_GeneralesDTO parametros_generalesDto = MapperUtils.DtoFromEntity(parametros_generalesFound.get(), Parametros_GeneralesDTO.class);
                return new ResponseEntity<>(parametros_generalesDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de Parametros_Generales:", response = Parametros_GeneralesDTO.class, tags = "Parametros_Generales")
    public ResponseEntity<?> create(@RequestBody Parametros_Generales parametros_generales) {
        try {
            Parametros_Generales parametros_generalesCreated = parametrosgeneralesService.create(parametros_generales);
            Parametros_GeneralesDTO parametros_generalesDto = MapperUtils.DtoFromEntity(parametros_generalesCreated, Parametros_GeneralesDTO.class);
            return new ResponseEntity<>(parametros_generalesDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Parametros_Generales:", response = Parametros_GeneralesDTO.class, tags = "Parametros_Generales")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Parametros_Generales parametros_generalesModified) {
        try {
            Optional<Parametros_Generales> parametros_generalesUpdated = parametrosgeneralesService.update(parametros_generalesModified, id);
            if (parametros_generalesUpdated.isPresent()) {
                Parametros_GeneralesDTO parametros_generalesDto = MapperUtils.DtoFromEntity(parametros_generalesUpdated.get(), Parametros_GeneralesDTO.class);
                return new ResponseEntity<>(parametros_generalesDto, HttpStatus.OK);

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
