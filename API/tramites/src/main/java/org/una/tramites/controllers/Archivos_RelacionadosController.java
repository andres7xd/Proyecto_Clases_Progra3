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
import org.una.tramites.dto.Archivos_RelacionadosDTO;
import org.una.tramites.entities.Archivos_Relacionados;
import org.una.tramites.services.IArchivos_RelacionadosService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@RestController
@RequestMapping("/archivos_relacionados") 
@Api(tags = {"Archivos_Relacionados"})

public class Archivos_RelacionadosController {
    
    @Autowired
    private IArchivos_RelacionadosService archivos_relacionadosService;

    @GetMapping() 
    @ApiOperation(value = "Obtiene una lista de todos los archivos relacionados", response = Archivos_RelacionadosDTO.class, responseContainer = "List", tags = "Archivos_Relacionados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Archivos_Relacionados>> result = archivos_relacionadosService.findAll();
            if (result.isPresent()) {
                List<Archivos_RelacionadosDTO> archivos_relacionadosDTO = MapperUtils.DtoListFromEntityList(result.get(), Archivos_RelacionadosDTO.class);
                return new ResponseEntity<>(archivos_relacionadosDTO, HttpStatus.OK);
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

            Optional<Archivos_Relacionados> notasFound = archivos_relacionadosService.findById(id);
            if (notasFound.isPresent()) {
                Archivos_RelacionadosDTO archivos_relacionadosDto = MapperUtils.DtoFromEntity(notasFound.get(), Archivos_RelacionadosDTO.class);
                return new ResponseEntity<>(archivos_relacionadosDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de un archivo relacionado:", response = Archivos_RelacionadosDTO.class, tags = "Archivos_Relacionados")
    public ResponseEntity<?> create(@RequestBody Archivos_Relacionados archivos_relacionados) {
        try {
            Archivos_Relacionados archivos_relacionadosCreated = archivos_relacionadosService.create(archivos_relacionados);
            Archivos_RelacionadosDTO archivos_relacionadosDto = MapperUtils.DtoFromEntity(archivos_relacionadosCreated, Archivos_RelacionadosDTO.class);
            return new ResponseEntity<>(archivos_relacionadosDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}") 
    @ResponseBody
    @ApiOperation(value = "Actualizacion de archivos relacionados:", response = Archivos_RelacionadosDTO.class, tags = "Archivos_Relacionados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Archivos_Relacionados archivos_relacionadosModified) {
        try {
            Optional<Archivos_Relacionados> archivos_relacionadosUpdated = archivos_relacionadosService.update(archivos_relacionadosModified, id);
            if (archivos_relacionadosUpdated.isPresent()) {
                Archivos_RelacionadosDTO archivos_relacionadosDto = MapperUtils.DtoFromEntity(archivos_relacionadosUpdated.get(), Archivos_RelacionadosDTO.class);
                return new ResponseEntity<>(archivos_relacionadosDto, HttpStatus.OK);

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
