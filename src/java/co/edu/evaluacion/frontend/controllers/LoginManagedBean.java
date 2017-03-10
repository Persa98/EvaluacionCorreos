/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.evaluacion.frontend.controllers;

import co.edu.evaluacion.backend.persistence.entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author Persa
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Usuario usuario;
    
    public LoginManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String cerrarSesion(){
        FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuario");
        context.getExternalContext().invalidateSession();
        usuario = null;
        return "index.xhtm?faces-redirect=true";
    }
}
