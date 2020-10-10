/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.Tramites_Cambios_EstadosDTO;
import org.una.tramites.services.ITramites_Cambios_EstadosService;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/tramites_cambios_estados")
@Api(tags = {"Tramites_Cambios_Estados"})
public class Tramites_Cambios_EstadosController {

    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";

    @Autowired
    private ITramites_Cambios_EstadosService tramites_Cambios_EstadosService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Tramites Cambios Estados", response = Tramites_Cambios_EstadosDTO.class, responseContainer = "List", tags = "Tramites_Cambios_Estados")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(tramites_Cambios_EstadosService.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity(tramites_Cambios_EstadosService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @ApiOperation(value = "Creacion de Tramites_Cambios_Estados:", response = Tramites_Cambios_EstadosDTO.class, tags = "Tramites_Cambios_Estados")
//    @PreAuthorize("hasAuthority('TRAMITES_CAMBIOS_ESTADOS_CREAR')")
    public ResponseEntity<?> create(@Valid @RequestBody Tramites_Cambios_EstadosDTO tramites_Cambios_EstadosDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(tramites_Cambios_EstadosService.create(tramites_Cambios_EstadosDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Tramites_Cambios_Estados:", response = Tramites_Cambios_EstadosDTO.class, tags = "Tramites_Cambios_Estados")
//    @PreAuthorize("hasAuthority('TRAMITES_CAMBIOS_ESTADOS_MODIFICAR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Tramites_Cambios_EstadosDTO tramites_Cambios_EstadosDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<Tramites_Cambios_EstadosDTO> tramites_Cambios_EstadosUpdated = tramites_Cambios_EstadosService.update(tramites_Cambios_EstadosDTO, id);
                if (tramites_Cambios_EstadosUpdated.isPresent()) {
                    return new ResponseEntity(tramites_Cambios_EstadosUpdated, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            tramites_Cambios_EstadosService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() {

        try {
            tramites_Cambios_EstadosService.deleteAll();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
