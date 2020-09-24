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
 * @author Luis
 */
@Entity

@Table(name = "Requisitos_Presentados")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString
public class Requisitos_Presentados implements Serializable {
    
   @ManyToOne
   @JoinColumn(name = "Tramites_Registrados_Id")
   private Tramites_Registrados Tramites_Registrados;
   
   @ManyToOne
   @JoinColumn(name = "Requisito_Id")
   private Requisito Requisitos;
  
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    
    @Column(name = "Fecha_Registro")

    @Setter(AccessLevel.NONE)

    @Temporal(TemporalType.DATE)

    private Date fecha_registro;
    
     public void prePersist() {

        fecha_registro = new Date();
        
    }
}
