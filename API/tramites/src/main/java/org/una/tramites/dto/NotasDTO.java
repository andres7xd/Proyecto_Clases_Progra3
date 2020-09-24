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
import org.una.tramites.entities.Tramites_Registrados;

/**
 *
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class NotasDTO {
   
    private Long id;
    private String titulo;
    private String contenido;
    private Date fecha_registro; 
    private Date fecha_modificacion;
    private int estado;
    private int tipo;
    private Tramites_Registrados tramites_registrados;
    
}
