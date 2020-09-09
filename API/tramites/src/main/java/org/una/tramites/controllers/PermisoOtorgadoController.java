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
import org.una.tramites.dto.PermisoOtorgadoDTO;
import org.una.tramites.entities.PermisoOtorgado;
import org.una.tramites.services.IPermisoOtorgadoService;
import org.una.tramites.utils.MapperUtils;
/**
 *
 * @author rache
 */
@RestController
@RequestMapping("/permisos_otorgados") 
@Api(tags = {"Permisos_Otorgados"})
public class PermisoOtorgadoController {
     @Autowired
    private IPermisoOtorgadoService permisoOtorgadoService;
    
    @GetMapping("/{id}") 
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<PermisoOtorgado> permisoOtorgadoFound = permisoOtorgadoService.findById(id);
            if (permisoOtorgadoFound.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoFound.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de permisoOtorgado:", response = PermisoOtorgadoDTO.class, tags = "Permisos_Otorgados")
    public ResponseEntity<?> create(@RequestBody PermisoOtorgado permisoOtorgado) {
        try {
            PermisoOtorgado permisoOtorgadoCreated = permisoOtorgadoService.create(permisoOtorgado);
            PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoCreated, PermisoOtorgadoDTO.class);
            return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}") 
    @ResponseBody
    @ApiOperation(value = "Actualizacion de permisoOtorgado:", response = PermisoOtorgadoDTO.class, tags = "Permisos_Otorgados")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PermisoOtorgado permisoOtorgadoModified) {
        try {
            Optional<PermisoOtorgado> permisoOtorgadoUpdated = permisoOtorgadoService.update(permisoOtorgadoModified, id);
            if (permisoOtorgadoUpdated.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoUpdated.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);

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
