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
public class ModeloReporteVenta {
     private String Fecha_Venta;
private String Numero_Documento;
private String Tipo_Documento;
private String Nombre_Tienda;
private String Nit_Tienda;
private String Nombre_Empleado;
private int Unidades_Vendidas;
private int Cantidad_prod;
private double Total_Venta;

    public String getFecha_Venta() {
        return Fecha_Venta;
    }

    public void setFecha_Venta(String Fecha_Venta) {
        this.Fecha_Venta = Fecha_Venta;
    }

    public String getNumero_Documento() {
        return Numero_Documento;
    }

    public void setNumero_Documento(String Numero_Documento) {
        this.Numero_Documento = Numero_Documento;
    }

    public String getTipo_Documento() {
        return Tipo_Documento;
    }

    public void setTipo_Documento(String Tipo_Documento) {
        this.Tipo_Documento = Tipo_Documento;
    }

    public String getNombre_Tienda() {
        return Nombre_Tienda;
    }

    public void setNombre_Tienda(String Nombre_Tienda) {
        this.Nombre_Tienda = Nombre_Tienda;
    }

    public String getNit_Tienda() {
        return Nit_Tienda;
    }

    public void setNit_Tienda(String Nit_Tienda) {
        this.Nit_Tienda = Nit_Tienda;
    }

    public String getNombre_Empleado() {
        return Nombre_Empleado;
    }

    public void setNombre_Empleado(String Nombre_Empleado) {
        this.Nombre_Empleado = Nombre_Empleado;
    }

    public int getUnidades_Vendidas() {
        return Unidades_Vendidas;
    }

    public void setUnidades_Vendidas(int Unidades_Vendidas) {
        this.Unidades_Vendidas = Unidades_Vendidas;
    }

   

    public int getCantidad_prod() {
        return Cantidad_prod;
    }

    public void setCantidad_prod(int Cantidad_prod) {
        this.Cantidad_prod = Cantidad_prod;
    }

    public double getTotal_Venta() {
        return Total_Venta;
    }

    public void setTotal_Venta(double Total_Venta) {
        this.Total_Venta = Total_Venta;
    }



}
