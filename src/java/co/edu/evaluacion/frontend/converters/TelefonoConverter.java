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
@FacesConverter(forClass = TelefonoConverter.class)
public class TelefonoConverter extends AbstractConverter{
    
    public TelefonoConverter(){
        this.nombreMB = "telefonoManagedBean";
    }
}
