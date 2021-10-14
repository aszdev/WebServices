/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import org.interfaces.CrudReporteVenta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelos.ModeloReporteVenta;
import org.config.Conexion;

/**
 *
 * @author MarcoVincio
 */
public class DaoReporteVenta  implements CrudReporteVenta{

    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
    
    @Override
    public List ListarReporte(String fechaInc, String fecha_fin, int tienda) {
       ArrayList<ModeloReporteVenta> lsventas = new ArrayList<>();
       
   try {           
          
            
             strSql = "exec usp_rptVenta "+ "'"+fechaInc+"'" + ",'"+fecha_fin+"'," + ""+tienda+"";
                 
                   
            conexion.open();
            rs = conexion.executeQuery(strSql);                            
            System.out.println("StrSql: " + strSql);
            while (rs.next()) {
                ModeloReporteVenta modv = new ModeloReporteVenta();
                modv.setFecha_Venta(rs.getString("Fecha Venta"));
                modv.setNumero_Documento(rs.getString("Numero Documento"));
                modv.setTipo_Documento(rs.getString("Tipo Documento"));
                modv.setNombre_Tienda(rs.getString("Nombre Tienda"));
                modv.setNit_Tienda(rs.getString("Nit Tienda"));
                modv.setNombre_Empleado(rs.getString("Nombre Empleado"));
                modv.setUnidades_Vendidas(rs.getInt("Cantidad Unidades Vendidas"));
                modv.setCantidad_prod(rs.getInt("Cantidad Productos"));
                modv.setTotal_Venta(rs.getDouble("Total Venta"));
                lsventas.add(modv);
            }
            rs.close();
            conexion.close();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoReporteVenta.class.getName()).log(Level.SEVERE, null, ex);           
        } catch(Exception ex){
            Logger.getLogger(DaoReporteVenta.class.getName()).log(Level.SEVERE, null, ex);           
        }
       
        return lsventas;
    }
    }