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
import org.modelos.ModeloUsuario;





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
    public boolean insertar(ModeloUsuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ModeloUsuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(ModeloUsuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List produtoTienda(int tienda, String producto) {
        ArrayList<ModeloProductoTienda>lsProdTienda = new ArrayList<>();
        
         try {            
            strSql = "exec usp_rptProductoTienda "+tienda+",'"+producto+"'";
        
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModeloProductoTienda ptienda = new ModeloProductoTienda();
                ptienda.setNit(rs.getString(0));
                ptienda.setNombretienda(rs.getString(1));
              /*  user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("passwd"));
                user.setCorreo(rs.getString("correo"));
                user.setNombre(rs.getString("nombreusual"));
                user.setEstatus(rs.getInt("activo"));
                user.setFecha_mod(rs.getString("modificadoEl"));
               */

                                
                lsProdTienda.add(ptienda);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProductoTienda.class.getName()).log(Level.SEVERE, null, ex);  
        } catch(Exception ex){
            Logger.getLogger(DaoProductoTienda.class.getName()).log(Level.SEVERE, null, ex);            
        }
             
         return lsProdTienda;
    }

    @Override
    public List listartodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModeloUsuario listaruno(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int loguear(String user, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
