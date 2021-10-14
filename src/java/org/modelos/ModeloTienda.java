/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.modelos;

/**
 *
 * @author MarcoVincio
 */
public class ModeloTienda {
      private int IdTienda;
    private String Nombre;
    private String Direccion;
    private String Telefono;

    public int getIdTienda() {
        return IdTienda;
    }

    public void setIdTienda(int IdTienda) {
        this.IdTienda = IdTienda;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    

}
