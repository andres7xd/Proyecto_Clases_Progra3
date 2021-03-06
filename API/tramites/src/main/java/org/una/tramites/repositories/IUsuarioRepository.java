/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.tramites.entities.Usuario;

/**
 *
 * @author rache
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByCedulaAndPasswordEncriptado(String cedula, String passwordEncriptado);

    public List<Usuario> findByCedulaContaining(String cedula);

    public List<Usuario> findByNombreCompletoContainingIgnoreCase(String nombreCompleto);

    public Usuario findByNombreCompleto(String nombreCompleto);

    public List<Usuario> findByDepartamentoId(Long id);

    @Query("SELECT u FROM Usuario u LEFT JOIN u.departamento d WHERE u.esJeFe=1 AND d.id=:id")
    public Optional<Usuario> findJefeByDepartamento(@Param("id") Long id);

    public Usuario findByCedula(String cedula);

    @Query("select u from Usuario u where UPPER(u.nombreCompleto) like CONCAT('%', UPPER(:nombreCompleto), '%')")
    public Usuario findNombreCompletoWithLikeSQL(@Param("nombreCompleto") String nombreCompleto);

}
