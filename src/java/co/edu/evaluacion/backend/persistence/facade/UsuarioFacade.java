/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.evaluacion.backend.persistence.facade;

import co.edu.evaluacion.backend.persistence.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Persa
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "EvaluacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario iniciarSesion(Usuario u) throws Exception {
        Usuario usuario = null;
        TypedQuery<Usuario> query;
        try {
            query = em.createQuery("FROM Usuario u WHERE u.docuemnto =?1 and u.clave =?2", Usuario.class);
            query.setParameter(1, u.getDocuemnto());
            query.setParameter(2, u.getClave());
            if (!query.getResultList().isEmpty()) {
                usuario = query.getResultList().get(0);
            }
        }catch (Exception e){
            throw e;
        }
        return usuario;
    }
    
}
