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
import org.una.tramites.dto.Requisitos_PresentadosDTO;
import org.una.tramites.entities.Requisitos_Presentados;
import org.una.tramites.services.IRequisitos_PresentadosService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@RestController
@RequestMapping("/requisitos_presentados") 
@Api(tags = {"Requisitos_Presentados"})

public class Requisitos_PresentadosController {
    
    @Autowired
    private IRequisitos_PresentadosService requisitos_presentadosService;

    @GetMapping() 
    @ApiOperation(value = "Obtiene una lista de todos los requisitos presentados", response = Requisitos_PresentadosDTO.class, responseContainer = "List", tags = "Requisitos_Presentados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Requisitos_Presentados>> result = requisitos_presentadosService.findAll();
            if (result.isPresent()) {
                List<Requisitos_PresentadosDTO> requisitos_presentadosDTO = MapperUtils.DtoListFromEntityList(result.get(), Requisitos_PresentadosDTO.class);
                return new ResponseEntity<>(requisitos_presentadosDTO, HttpStatus.OK);
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

            Optional<Requisitos_Presentados> requisitos_presentadosFound = requisitos_presentadosService.findById(id);
            if (requisitos_presentadosFound.isPresent()) {
                Requisitos_PresentadosDTO requisitos_presentadosDto = MapperUtils.DtoFromEntity(requisitos_presentadosFound.get(), Requisitos_PresentadosDTO.class);
                return new ResponseEntity<>(requisitos_presentadosDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de una requisito presentado:", response = Requisitos_PresentadosDTO.class, tags = "Requisitos_Presentados")
    public ResponseEntity<?> create(@RequestBody Requisitos_Presentados requisitos_presentados) {
        try {
            Requisitos_Presentados requisitos_presentadosCreated = requisitos_presentadosService.create(requisitos_presentados);
            Requisitos_PresentadosDTO requisitos_presentadosDto = MapperUtils.DtoFromEntity(requisitos_presentadosCreated, Requisitos_PresentadosDTO.class);
            return new ResponseEntity<>(requisitos_presentadosDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}") 
    @ResponseBody
    @ApiOperation(value = "Actualizacion de requisitos presentados:", response = Requisitos_PresentadosDTO.class, tags = "Requisitos_Presentados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Requisitos_Presentados requisitos_presentadosModified) {
        try {
            Optional<Requisitos_Presentados> requisitos_presentadosUpdated = requisitos_presentadosService.update(requisitos_presentadosModified, id);
            if (requisitos_presentadosUpdated.isPresent()) {
                Requisitos_PresentadosDTO requisitos_presentadosDto = MapperUtils.DtoFromEntity(requisitos_presentadosUpdated.get(), Requisitos_PresentadosDTO.class);
                return new ResponseEntity<>(requisitos_presentadosDto, HttpStatus.OK);

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
