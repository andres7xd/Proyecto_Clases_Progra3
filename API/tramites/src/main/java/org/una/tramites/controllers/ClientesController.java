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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.ClientesDTO;
import org.una.tramites.services.IClientesService;
import org.una.tramites.services.ITramites_EstadosService;

/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/clientes") 
@Api(tags = {"Clientes"})
public class ClientesController {
    
    final String MENSAJE_VERIFICAR_INFORMACION = "Debe verifiar el formato y la información de su solicitud con el formato esperado";
    
    @Autowired
    private IClientesService clientesService;
    
    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Clientes", response = ClientesDTO.class, responseContainer = "List", tags = "Clientes")
//    @PreAuthorize("hasAuthority('CLIENTE_CONSULTAR_TODO')")
    public @ResponseBody
    ResponseEntity<?> findAll() {
      try {
            return new ResponseEntity<>(clientesService.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
       try {
            return new ResponseEntity(clientesService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    @ApiOperation(value = "Creacion de Clientes:", response = ClientesDTO.class, tags = "Clientes")
//    @PreAuthorize("hasAuthority('CLIENTE_CREAR')")
    public ResponseEntity<?> create(@Valid @RequestBody ClientesDTO clientesDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                return new ResponseEntity(clientesService.create(clientesDTO), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity(MENSAJE_VERIFICAR_INFORMACION, HttpStatus.BAD_REQUEST);
        }
    }
//    
//    @GetMapping("/Informacion/{informacion}")
//    public ResponseEntity<?> findByInformacion(@PathVariable(value = "informacion") String informacion) {
//        try {
//            return new ResponseEntity(IClienteService.findByInformacion(informacion), HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Actualizacion de Clientes:", response = ClientesDTO.class, tags = "Clientes")
//    @PreAuthorize("hasAuthority('CLIENTE_MODIFICAR')")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody ClientesDTO clientesDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                Optional<ClientesDTO> clientesUpdated = clientesService.update(clientesDTO, id);
                if (clientesUpdated.isPresent()) {
                    return new ResponseEntity(clientesUpdated, HttpStatus.OK);
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
            clientesService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAll() {
       try {
            clientesService.deleteAll();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
}
