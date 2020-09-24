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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Luis
 */
@Entity

@Table(name = "Archivos_Relacionados")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Archivos_Relacionados implements Serializable {
//    @ManyToOne
//    @JoinColumn(name = "Tramites_Registrados_Id")
//    private Tramites_Registrados tramites_registrados;

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    
    @Column(name = "Nombre", length = 50)

    private String nombre;
    
    @Column(name = "Tipo", length = 50)

    private int tipo;
    
    @Column(name = "Estado", length = 50)

    private int estado;
    
    @Column(name = "Ruta_Archivo", length = 50)

    private String ruta_archivo;
    
    @Column(name = "Fecha_Registro")

    private Date fecha_registro;
    
    @Column(name = "Etiquetas", length = 50)

    private String etiquetas;
    
    @Column(name = "Fecha_Modificacion")

    private Date fecha_modificacion;
    
     public void prePersist() {

        fecha_registro = new Date();

        fecha_modificacion = new Date();

    }
     
     @PreUpdate

    public void preUpdate() {

        fecha_modificacion = new Date();

    }

}
