/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.tramites.entities.PermisoOtorgado;

/**
 *
 * @author rache
 */
public interface IPermisoOtorgadoRepository extends JpaRepository<PermisoOtorgado, Long> {

   // @Query("SELECT u FROM PermisoOtorgado u WHERE u.estado = estado_permiso_otorgado")
    public List<PermisoOtorgado> findByEstadoContaining(Boolean estado);

    @Query("SELECT u FROM PermisoOtorgado u WHERE u.usuarios = usuarios_id")
    public List<PermisoOtorgado> findByUsuarioId(@Param("usuarios_id") Long usuarioId);

    @Query("SELECT u FROM PermisoOtorgado u WHERE u.usuarios = usuarios_id  AND u.estado = estado_permiso_otorgado")
    public List<PermisoOtorgado> findByUsuarioIdAndEstado(@Param("usuarios_id") Long usuarioId, @Param("estado_permiso_otorgado") boolean estado);

    @Query("SELECT u FROM PermisoOtorgado u WHERE u.permisos = permisos_id  AND u.estado = estado_permiso_otorgado")
    public List<PermisoOtorgado> findByPermisoIdAndEstado(@Param("permisos_id") Long permisoId, @Param("estado_permiso_otorgado")boolean estado);

    @Query("SELECT u FROM PermisoOtorgado u  WHERE u.fechaRegistro BETWEEN starDate AND endDate ")
    public List<PermisoOtorgado> findByFechaRegistroBetween(@Param("starDate")Date startDate,@Param("endDate") Date endDate);

    @Query("SELECT u FROM PermisoOtorgado u WHERE u.permisos = permisos_id")
    public List<PermisoOtorgado> findByPermisoId(@Param("permisos_id") Long permisoId);
}
