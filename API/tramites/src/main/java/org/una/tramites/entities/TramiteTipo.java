/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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

@Table(name = "tramite_tipo")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class TramiteTipo {
    private static final long serialVersionUID = 1L;
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "descripcion", length = 100)

    private String descripciontramite;


    @Column

    private boolean estado;

    @Column(name = "fecha_registro", updatable = false)

    @Temporal(TemporalType.DATE)

    @Setter(AccessLevel.NONE)

    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")

    @Setter(AccessLevel.NONE)

    @Temporal(TemporalType.DATE)

    private Date fechaModificacion;

    @ManyToOne 
    @JoinColumn(name="departamentos_id")
    private Departamento departamento;

    @PrePersist

    public void prePersist() {

        estado = true;



        fechaRegistro = new Date();

        fechaModificacion = new Date();

    }

    @PreUpdate

    public void preUpdate() {

        fechaModificacion = new Date();

    }
}
