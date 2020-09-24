/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

@Table(name = "Tramites_Registrados")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Tramites_Registrados implements Serializable{
    
//    @ManyToOne
//    @JoinColumn(name = "Clientes_Id")
//    private Clientes clientes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Notas") 
    private List<Notas> notas = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Archivos_Relacionados") 
    private List<Archivos_Relacionados> archivos_relacionados = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Requisitos_Presentados") 
    private List<Requisitos_Presentados> requisitos_presentados = new ArrayList<>();
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Tramites_Cambios_Estados") 
//    private List<Tramites_Cambios_Estados> tramites_cambios_estados = new ArrayList<>();
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    
}
