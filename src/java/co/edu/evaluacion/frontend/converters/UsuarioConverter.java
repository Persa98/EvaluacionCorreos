/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.evaluacion.frontend.converters;

import co.edu.evaluacion.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Persa
 */
@FacesConverter(forClass = UsuarioConverter.class)
public class UsuarioConverter extends AbstractConverter{
    
    public UsuarioConverter(){
        this.nombreMB = "usuarioManagedBean";
    }
    
}
