/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.evaluacion.frontend.controllers;

import co.edu.evaluacion.backend.persistence.entities.Telefono;
import co.edu.evaluacion.backend.persistence.facade.TelefonoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Persa
 */
@Named(value = "telefonoManagedBean")
@SessionScoped
public class TelefonoManagedBean implements Serializable {

    private Telefono telefono;
    @EJB
    private TelefonoFacadeLocal tfl; 
    
    public TelefonoManagedBean() {
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    
    @PostConstruct
    public void init(){
        telefono = new Telefono();
    }
    
    public void registrarTelefono(){
        tfl.create(telefono);
    }
    
}
