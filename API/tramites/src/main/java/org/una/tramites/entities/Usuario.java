/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
 * @author rache
 */
@Entity

@Table(name = "usuarios")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString

public class Usuario implements Serializable {

    @ManyToOne
    @JoinColumn(name = "departamentos_id")
    private Departamento departamento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios") 
    private List<PermisoOtorgado> permisoOtorgados= new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios") 
    private List<Tramites_Cambios_Estados> tramitescambiosestados= new ArrayList<>();
    

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nombre_completo", length = 100)

    private String nombreCompleto;

    @Column(length = 100, name = "password_encriptado")

    private String passwordEncriptado;

    @Column(length = 25, unique = true)

    private String cedula;

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

    @Column(name = "es_Jefe")

    private boolean esJeFe;

    private static final long serialVersionUID = 1L;

    @PrePersist

    public void prePersist() {

        estado = true;

        esJeFe = false;

        fechaRegistro = new Date();

        fechaModificacion = new Date();

    }

    @PreUpdate

    public void preUpdate() {

        fechaModificacion = new Date();

    }

}
