/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import java.util.Date;
import org.una.tramites.entities.Transaccion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author rache
 */
public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

    @Query("SELECT u FROM Transaccion u  JOIN u.permisos_otorgados v WHERE v.usuarios = usuarios_id  AND u.fechaRegistro BETWEEN starDate AND endDate ")
    public List<Transaccion> findByUsuarioIdAndFechaRegistroBetween(@Param("usuarios_id") Long usuarioId, @Param("starDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT u FROM Transaccion u  JOIN u.permisos_otorgados v WHERE v.permisos = permisos_id  AND u.fechaRegistro BETWEEN starDate AND endDate ")
    public List<Transaccion> findByPermisoIdAndFechaRegistroBetween(@Param("permisos_id") Long permisoId, @Param("starDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT u FROM Transaccion u  WHERE u.objeto= objetostr  AND u.fechaRegistro BETWEEN starDate AND endDate ")
    public List<Transaccion> findByObjetoAndFechaRegistroBetween(@Param("objetostr") String objeto, @Param("starDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT u FROM Transaccion u   WHERE  u.fechaRegistro BETWEEN starDate AND endDate ")
    public List<Transaccion> findByFechaRegistroBetween(@Param("starDate") Date startDate, @Param("endDate") Date endDate);

     @Query("SELECT u FROM Transaccion u  JOIN u.permisos_otorgados v WHERE v.estado = estado_permiso_otorgado")
    public List<Transaccion> findByEstadoContaining(@Param("estado_permiso_otorgado")Boolean estado);

}
