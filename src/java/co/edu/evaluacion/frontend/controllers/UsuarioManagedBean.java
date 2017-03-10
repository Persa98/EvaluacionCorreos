/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.evaluacion.frontend.controllers;

import co.edu.evaluacion.backend.persistence.entities.Usuario;
import co.edu.evaluacion.backend.persistence.facade.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Persa
 */
@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable {

    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal ufc;
    
    public UsuarioManagedBean(){
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public void registrarUsuario(){
        ufc.create(usuario);
    }
    
    public String iniciarSesion(){
        try{
            Usuario u = ufc.iniciarSesion(usuario);
            FacesContext context = FacesContext.getCurrentInstance();
            if (u!= null){
                context.getExternalContext().getSessionMap().put("usuario", u);
                return "/security/inicio.xhtml?faces-redirect=true";
            }
        }catch (Exception e){
        }
        usuario = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error Mi Manito"));
        return null;
    }
    
}
