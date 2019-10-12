/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webonline.core.model;

/**
 *
 * @author EDUARDO
 */
public class DeleteResponse {
     private String mensaje;

    public DeleteResponse() {
    }

    public DeleteResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}



