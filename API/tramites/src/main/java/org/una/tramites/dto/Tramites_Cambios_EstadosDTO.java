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
import org.una.tramites.entities.Tramites_Estados;
import org.una.tramites.entities.Tramites_Registrados;
import org.una.tramites.entities.Usuario;

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
    private Usuario usuarios;
   private Tramites_Registrados Tramites_Registrados;
    private Tramites_Estados Tramites_Estados;
}
