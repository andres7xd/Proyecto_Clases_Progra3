/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.dto;

import java.util.Date;
import org.una.tramites.entities.PermisoOtorgado;

/**
 *
 * @author rache
 */
public class TransaccionDTO {
    private Long id; 
    private String objeto; 
    private Date fechaRegistro; 
    private String informacion;
    private PermisoOtorgado permisootorgado;
}
