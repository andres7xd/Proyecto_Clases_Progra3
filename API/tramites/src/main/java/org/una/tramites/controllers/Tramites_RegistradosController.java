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
import org.una.tramites.dto.Tramites_RegistradosDTO;
import org.una.tramites.entities.Tramites_Registrados;
import org.una.tramites.services.ITramites_RegistradosService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@RestController
@RequestMapping("/tramites_registrados") 
@Api(tags = {"Tramites_Registrados"})

public class Tramites_RegistradosController {
   
    @Autowired
    private ITramites_RegistradosService tramites_registradosService;

    @GetMapping() 
    @ApiOperation(value = "Obtiene una lista de todas los tramites registrados", response = Tramites_RegistradosDTO.class, responseContainer = "List", tags = "Tramites_Registrados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Tramites_Registrados>> result = tramites_registradosService.findAll();
            if (result.isPresent()) {
                List<Tramites_RegistradosDTO> tramites_registradosDTO = MapperUtils.DtoListFromEntityList(result.get(), Tramites_RegistradosDTO.class);
                return new ResponseEntity<>(tramites_registradosDTO, HttpStatus.OK);
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

            Optional<Tramites_Registrados> tramites_registradosFound = tramites_registradosService.findById(id);
            if (tramites_registradosFound.isPresent()) {
                Tramites_RegistradosDTO tramites_registradosDto = MapperUtils.DtoFromEntity(tramites_registradosFound.get(), Tramites_RegistradosDTO.class);
                return new ResponseEntity<>(tramites_registradosDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de un tramite registrado:", response = Tramites_RegistradosDTO.class, tags = "Tramites_Registrados")
    public ResponseEntity<?> create(@RequestBody Tramites_Registrados tramites_registrados) {
        try {
            Tramites_Registrados tramites_registradosCreated = tramites_registradosService.create(tramites_registrados);
            Tramites_RegistradosDTO tramites_registradosDto = MapperUtils.DtoFromEntity(tramites_registradosCreated, Tramites_RegistradosDTO.class);
            return new ResponseEntity<>(tramites_registradosDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}") 
    @ResponseBody
    @ApiOperation(value = "Actualizacion de tramites registrados:", response = Tramites_RegistradosDTO.class, tags = "Tramites_Registrados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Tramites_Registrados tramites_registradosModified) {
        try {
            Optional<Tramites_Registrados> tramites_registradosUpdated = tramites_registradosService.update(tramites_registradosModified, id);
            if (tramites_registradosUpdated.isPresent()) {
                Tramites_RegistradosDTO tramites_registradosDto = MapperUtils.DtoFromEntity(tramites_registradosUpdated.get(), Tramites_RegistradosDTO.class);
                return new ResponseEntity<>(tramites_registradosDto, HttpStatus.OK);

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
