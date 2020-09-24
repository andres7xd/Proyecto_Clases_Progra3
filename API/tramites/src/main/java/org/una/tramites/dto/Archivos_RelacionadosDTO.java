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
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class Archivos_RelacionadosDTO {
   
    private Long id;
    private String nombre;
    private int tipo;
    private int estado;
    private String ruta_archivo;
    private Date fecha_registro;
    private Date fecha_modificacion;
    private String modificacion;
//    private Tramites_Registrados Tramites_registrados_Id

}
