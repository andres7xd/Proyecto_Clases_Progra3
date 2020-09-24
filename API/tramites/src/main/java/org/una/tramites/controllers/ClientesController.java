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
import org.una.tramites.dto.ClientesDTO;
import org.una.tramites.entities.Clientes;
import org.una.tramites.services.IClientesService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/clientes") 
@Api(tags = {"Clientes"})
public class ClientesController {
    
    @Autowired
    private IClientesService clientesService;
    
    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Clientes", response = ClientesDTO.class, responseContainer = "List", tags = "Clientes")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Clientes>> result = clientesService.findAll();
            if (result.isPresent()) {
                List<ClientesDTO> clientessDTO = MapperUtils.DtoListFromEntityList(result.get(), ClientesDTO.class);
                return new ResponseEntity<>(clientessDTO, HttpStatus.OK);
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

            Optional<Clientes> clientesFound = clientesService.findById(id);
            if (clientesFound.isPresent()) {
                ClientesDTO clientesDto = MapperUtils.DtoFromEntity(clientesFound.get(), ClientesDTO.class);
                return new ResponseEntity<>(clientesDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de Clientes:", response = ClientesDTO.class, tags = "Clientes")
    public ResponseEntity<?> create(@RequestBody Clientes clientes) {
        try {
            Clientes clientesCreated = clientesService.create(clientes);
            ClientesDTO clientesDto = MapperUtils.DtoFromEntity(clientesCreated, ClientesDTO.class);
            return new ResponseEntity<>(clientesDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Clientes:", response = ClientesDTO.class, tags = "Clientes")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Clientes clientesModified) {
        try {
            Optional<Clientes> clientesUpdated = clientesService.update(clientesModified, id);
            if (clientesUpdated.isPresent()) {
                ClientesDTO clientesDto = MapperUtils.DtoFromEntity(clientesUpdated.get(), ClientesDTO.class);
                return new ResponseEntity<>(clientesDto, HttpStatus.OK);

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
