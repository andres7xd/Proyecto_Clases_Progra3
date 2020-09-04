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
import org.una.tramites.dto.TransaccionDTO;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.services.ITransaccionService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author rache
 */
public class TransaccionController {

    @Autowired
    private ITransaccionService transaccionService;
    @GetMapping() 
    @ApiOperation(value = "Obtiene una lista de todos los departamentos", response = TransaccionDTO.class, responseContainer = "List", tags = "Transacciones")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Transaccion>> result = transaccionService.findAll();
            if (result.isPresent()) {
                List<TransaccionDTO> transaccionDTO = MapperUtils.DtoListFromEntityList(result.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionDTO, HttpStatus.OK);
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

            Optional<Transaccion> transaccionFound = transaccionService.findById(id);
            if (transaccionFound.isPresent()) {
                TransaccionDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionFound.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de departamento:", response = TransaccionDTO.class, tags = "Trancciones")
    public ResponseEntity<?> create(@RequestBody Transaccion transaccion) {
        try {
            Transaccion transaccionCreated = transaccionService.create(transaccion);
            TransaccionDTO transaccionDTO = MapperUtils.DtoFromEntity(transaccionCreated, TransaccionDTO.class);
            return new ResponseEntity<>(transaccionDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de departamento:", response = TransaccionDTO.class, tags = "Trancciones")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Transaccion transaccionModified) {
        try {
            Optional<Transaccion> transaccionUpdated = transaccionService.update(transaccionModified, id);
            if (transaccionUpdated.isPresent()) {
                TransaccionDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionUpdated.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);

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
