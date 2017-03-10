/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.evaluacion.backend.persistence.facade;

import co.edu.evaluacion.backend.persistence.entities.Correo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Persa
 */
@Stateless
public class CorreoFacade extends AbstractFacade<Correo> implements CorreoFacadeLocal {

    @PersistenceContext(unitName = "EvaluacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreoFacade() {
        super(Correo.class);
    }
    
}
