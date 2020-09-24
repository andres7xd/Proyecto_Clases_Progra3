/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@Table(name = "Tramites_Estados")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Tramites_Estados {

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Tramites_Estados") 
//    private List<Tramites_Cambios_Estados> tramites_cambios_estados= new ArrayList<>();
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "Nombre", length = 50)

    private String nombre;
    
    @Column(name = "Descripcion", length = 150)

    private String descripcion;
    
    @Column(name = "EstadosSucesores", length = 50)

    private String estadosSucesores;
}
