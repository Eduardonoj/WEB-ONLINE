/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webonline.core.model;

import java.io.Serializable;

/**
 *
 * @author cmayen
 */
public class TipoEmpaque implements Serializable{
    private int codigoEmpaque;
    private String descripcion;

    public TipoEmpaque() {
    }

    public TipoEmpaque(int codigoEmpaque, String descripcion) {
        this.codigoEmpaque = codigoEmpaque;
        this.descripcion = descripcion;
    }

    public int getCodigoEmpaque() {
        return codigoEmpaque;
    }

    public void setCodigoEmpaque(int codigoEmpaque) {
        this.codigoEmpaque = codigoEmpaque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
