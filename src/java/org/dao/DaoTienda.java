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
import org.interfaces.CrudTienda;
import org.modelos.ModeloTienda;

/**
 *
 * @author MarcoVincio
 */
public class DaoTienda implements CrudTienda{
  String strSql =  "";
    Conexion conexion = new Conexion();
    ResultSet rs = null;
    boolean respuesta = false;
    @Override
    public List listar() {
        List<ModeloTienda>lstTienda = new ArrayList<>();
         try {            
            strSql = "select * from dbo.tienda";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            System.out.println("StrSql: " + strSql);
            while (rs.next()) {
                ModeloTienda tienda = new ModeloTienda();
                tienda.setIdTienda(rs.getInt("IdTienda"));
                tienda.setNombre(rs.getString("Nombre"));
                tienda.setDireccion(rs.getString("Direccion"));
                tienda.setTelefono(rs.getString("Telefono"));
                lstTienda.add(tienda);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoTienda.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoTienda.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstTienda;
    }

    

    @Override
    public ModeloTienda list(int IdTienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean obtener(ModeloTienda tienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
