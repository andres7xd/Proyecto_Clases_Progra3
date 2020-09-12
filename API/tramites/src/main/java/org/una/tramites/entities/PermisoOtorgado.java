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

@Table(name = "permisos_otorgados")

@Data

@AllArgsConstructor

@NoArgsConstructor

@ToString



public class PermisoOtorgado implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "permisos_id")
    private Permiso permisos;
    
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuarios;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisos_otorgados") 
//    private List<Transaccion> transaccion= new ArrayList<>();
     
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    @Column

    private boolean estado;
    

    @Column(name = "fecha_registro", updatable = false)

    @Temporal(TemporalType.DATE)

    @Setter(AccessLevel.NONE)

    private Date fechaRegistro;

    

    
    @PrePersist

    public void prePersist() {

        estado = true;

       

        fechaRegistro = new Date();

       

    }



}
