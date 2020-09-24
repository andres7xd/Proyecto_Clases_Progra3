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
public class Tramites_Cambios_EstadosDTO {
     
    private Date fechaRegistro;
    private Long id;
//    private Usuarios usuarios;
//    private Tramites_Registrados tramitesregistrados;
//    private Tramites_Estados tramitesestados;
}
