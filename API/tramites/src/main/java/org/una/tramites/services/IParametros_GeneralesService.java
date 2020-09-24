/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Parametros_Generales;

/**
 *
 * @author andre
 */
public interface IParametros_GeneralesService {

    public Optional<Parametros_Generales> findById(Long id);

    public Parametros_Generales create(Parametros_Generales parametrosGenerales);

    public Optional<Parametros_Generales> update(Parametros_Generales parametrosGenerales, Long id);

    public void delete(Long id);

    public void deleteAll();

    public Optional<List<Parametros_Generales>> findAll();

}
