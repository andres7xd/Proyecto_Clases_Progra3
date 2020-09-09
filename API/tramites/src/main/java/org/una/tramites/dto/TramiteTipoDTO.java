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
import org.una.tramites.entities.Departamento;

/**
 *
 * @author andre
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class TramiteTipoDTO {
 private long id;
 private String descripcion;
 private boolean estado;
 private Departamento departamento;
 private Date fecha_registro;
 private Date fecha_modificacion;
 
}
