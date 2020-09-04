/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.entities;

import java.io.Serializable;
import java.util.Date;
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

@Table(name = "transacciones")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Transaccion implements Serializable {

    @ManyToOne
    @JoinColumn(name = "permisos_otorgados_id")
    private PermisoOtorgado permisos_otorgados;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Transaccion")

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "Objeto", length = 50)

    @Id
    private String objeto;

    @Column(name = "Informacion")

    private String informacion;

    @Column(name = "fecha_registro")

    @Setter(AccessLevel.NONE)

    @Temporal(TemporalType.DATE)

    private Date fechaRegistro;

    private static final long serialVersionUID = 1L;

    @PrePersist

    public void prePersist() {

        fechaRegistro = new Date();

    }

}
