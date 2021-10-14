/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudProductoTienda;
import org.modelos.ModeloProductoTienda;
import org.modelos.ModeloPrueba;

public class DaoProductoTienda implements  CrudProductoTienda{

    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
   
    @Override
    public List produtoTienda(int tienda, String producto) {
        ArrayList<ModeloProductoTienda> lsProdTienda = new ArrayList<>();
           
        
        try {            
            strSql = " exec usp_rptProductoTienda "+tienda+",'"+producto+"'";
             System.out.println(strSql);
            conexion.open();
            rs = conexion.executeQuery(strSql); 
                 
           // ModeloProductoTienda   mt = null;
         while (rs.next()) {
          
            ModeloProductoTienda ptienda = new ModeloProductoTienda();  
   
                        ptienda.setNit(rs.getString("Nit Tienda"));
                        ptienda.setNombretienda(rs.getString("Nombre Tienda"));
                        ptienda.setDireccion(rs.getString("Direccion Tienda"));
                        ptienda.setCodigoprod(rs.getString("Codigo Producto"));
                        ptienda.setNombreProducto(rs.getString("Nombre Producto"));
                        ptienda.setDescripcion(rs.getString("Descripcion Producto"));
                        ptienda.setStock(rs.getInt("Stock en tienda"));
                        ptienda.setPrecioCompra(rs.getInt("Precio Compra"));
                        ptienda.setPrecioVenta(rs.getInt("Precio Venta"));
                                
                lsProdTienda.add(ptienda);
            }
            
            rs.close();
            conexion.close();
            
            
            
       
        } catch(Exception ex){
            Logger.getLogger(DaoProductoTienda.class.getName()).log(Level.SEVERE, null, ex);            
        }
             
         return lsProdTienda;
    }
   
}
