/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author andre
 */
@Entity

@Table(name = "tramites_cambios_estados")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Tramites_Cambios_Estados implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuarios;
    
    @ManyToOne
    @JoinColumn(name = "tramites_estados_id")
    private Tramites_Estados Tramites_Estados;
    
    @ManyToOne
    @JoinColumn(name = "tramites_registrados_id")
    private Tramites_Registrados Tramites_Registrados;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;
    
    
}
