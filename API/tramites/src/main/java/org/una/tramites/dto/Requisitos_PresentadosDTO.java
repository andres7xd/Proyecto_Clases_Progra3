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
import org.una.tramites.entities.Requisito;
import org.una.tramites.entities.Tramites_Registrados;

/**
 *
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class Requisitos_PresentadosDTO {

    private Long id;
    private Date fecha_registro; 
    private Tramites_Registrados Tramites_registrados_Id;
    private Requisito requisito;
}
