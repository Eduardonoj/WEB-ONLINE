
package com.webonline.core.model;

import java.io.Serializable;


public class CreatedResponse implements Serializable {
    private Categoria categoria;
    private String mensaje;

    public CreatedResponse() {
    }

    public CreatedResponse(Categoria categoria, String mensaje) {
        this.categoria = categoria;
        this.mensaje = mensaje;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
