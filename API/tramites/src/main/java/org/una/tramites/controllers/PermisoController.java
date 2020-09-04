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
import org.una.tramites.dto.PermisoDTO;
import org.una.tramites.entities.Permiso;
import org.una.tramites.services.IPermisoService;
import org.una.tramites.utils.MapperUtils;
/**
 *
 * @author rache
 */
@RestController
@RequestMapping("/permisos") 
@Api(tags = {"Permisos"})
public class PermisoController {
    @Autowired
    private IPermisoService permisoService;

//    @GetMapping() 
//    @ApiOperation(value = "Obtiene una lista de todos los permisos", response = PermisoDTO.class, responseContainer = "List", tags = "Permisos")
//    public @ResponseBody
//    ResponseEntity<?> findAll() {
//        try {
//            Optional<List<Permiso>> result = permisoService.findAll();
//            if (result.isPresent()) {
//                List<PermisoDTO> permisosDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoDTO.class);
//                return new ResponseEntity<>(permisosDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    @GetMapping("/{id}") 
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Permiso> permisoFound = permisoService.findById(id);
            if (permisoFound.isPresent()) {
                PermisoDTO permisoDto = MapperUtils.DtoFromEntity(permisoFound.get(), PermisoDTO.class);
                return new ResponseEntity<>(permisoDto, HttpStatus.OK);
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
    @ApiOperation(value = "Creacion de permiso:", response = PermisoDTO.class, tags = "Permisos")
    public ResponseEntity<?> create(@RequestBody Permiso permiso) {
        try {
            Permiso permisoCreated = permisoService.create(permiso);
            PermisoDTO permisoDto = MapperUtils.DtoFromEntity(permisoCreated, PermisoDTO.class);
            return new ResponseEntity<>(permisoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}") 
    @ResponseBody
    @ApiOperation(value = "Actualizacion de permiso:", response = PermisoDTO.class, tags = "Permisos")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Permiso permisoModified) {
        try {
            Optional<Permiso> permisoUpdated = permisoService.update(permisoModified, id);
            if (permisoUpdated.isPresent()) {
                PermisoDTO permisoDto = MapperUtils.DtoFromEntity(permisoUpdated.get(), PermisoDTO.class);
                return new ResponseEntity<>(permisoDto, HttpStatus.OK);

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
