/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.dto;

import java.util.Date;
import org.una.tramites.entities.TramiteTipo;

/**
 *
 * @author andre
 */
public class VariacionDTO {
    private Long id;
    private boolean grupo;
    private String descripcion;
    private boolean estado;
    private Date fecha_registro;
    private TramiteTipo tramitetipo;
}
