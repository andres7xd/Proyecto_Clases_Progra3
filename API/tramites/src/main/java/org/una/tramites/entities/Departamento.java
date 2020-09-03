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
 * @author Luis
 */
@Entity

@Table(name = "departamentos")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString

public class Departamento implements Serializable {
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento") 
    private List<Usuario> usuarios= new ArrayList<>();

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nombre", length = 50)

    private String nombre;

    @Column(name = "fecha_registro")

    @Setter(AccessLevel.NONE)

    @Temporal(TemporalType.DATE)

    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")

    @Setter(AccessLevel.NONE)

    @Temporal(TemporalType.DATE)

    private Date fechaModificacion;
    
    private boolean estado;
    
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
