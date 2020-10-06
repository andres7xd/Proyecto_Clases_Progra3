/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author andre
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class ClientesDTO {
    
    private Long id;
    private String nombre_completo;
    private String cedula;
    private String telefono;
    private String direccion;
    private Date fechaRegistro; 
    private Date fechaModificacion;
    private String passwordEncriptado;
    private boolean estado;
    
}
