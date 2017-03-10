/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.evaluacion.frontend.controllers;

import co.edu.evaluacion.backend.persistence.entities.Correo;
import co.edu.evaluacion.backend.persistence.facade.CorreoFacadeLocal;
import co.edu.evaluacion.frontend.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Persa
 */
@Named(value = "correoManagedBean")
@SessionScoped
public class CorreoManagedBean implements Serializable, Managedbean <Correo> {

    private Correo correo;
    @EJB
    private CorreoFacadeLocal cfl;
    
    public CorreoManagedBean() {
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }
    
    @PostConstruct
    public void init(){
        correo = new Correo();
    }
    
    public void registrarCorreo(){
        cfl.create(correo);
    }

    public List<Correo> listarCorreo(){
        return cfl.findAll();
    }
    
    @Override
    public Correo getObject(Integer i) {
        return cfl.find(i);
    }
    
}
