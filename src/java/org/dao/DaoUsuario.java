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
import org.interfaces.CrudUsuario;
import org.modelos.ModeloUsuario;


public class DaoUsuario implements  CrudUsuario{

    
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
    
    
    
    @Override
    public List listartodos() {
        ArrayList<ModeloUsuario>lstUsuario = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM usuarios";
        
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModeloUsuario user = new ModeloUsuario();
                user.setId(rs.getInt("id"));
                user.setIdrol(rs.getInt("idrol"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("passwd"));
                user.setCorreo(rs.getString("correo"));
                user.setNombre(rs.getString("nombreusual"));
                user.setEstatus(rs.getInt("activo"));
                user.setFecha_mod(rs.getString("modificadoEl"));
               

                                
                lstUsuario.add(user);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);  
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
             
         return lstUsuario;
    }

    @Override
    public ModeloUsuario listaruno(int id) {
            
         ModeloUsuario user = new ModeloUsuario();
        try {            
            strSql = "SELECT * FROM usuarios";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
           
            while (rs.next()) {
                
                user.setId(rs.getInt("id"));
                user.setIdrol(rs.getInt("idRol"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("passwd"));
                user.setCorreo(rs.getString("correo"));
                user.setNombre(rs.getString("nombreUsual"));
                user.setEstatus(rs.getInt("activo"));
                user.setFecha_mod(rs.getString("modificadoEl"));
               
                                
             
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
   
         return user;
    }

    @Override
    public boolean insertar(ModeloUsuario usuario) {
         //Se prepara la sentencia SQL a ejecutar en la BD
              
       strSql = "insert into usuarios(idRol,usuario,passwd,correo,nombreUsual,activo,modificadoEl)" +
"values(" + usuario.getIdrol() + ",'"+ usuario.getUsuario() +"','"+usuario.getPassword()+"',"
               + "'"+ usuario.getCorreo() + "','" + usuario.getNombre() + "',"
               + ""+ usuario.getEstatus() +",getdate()) ";   
        try {
         
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModeloUsuario usuario) {
               //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE usuarios " +
                 "SET " +
                "idRol = " + usuario.getIdrol()+ "," +
                 "usuario = '" + usuario.getUsuario()+ "', " +
                 "passwd = '" + usuario.getPassword()+ "', " + 
                 "correo = '" + usuario.getCorreo()+ "', " +
                 "nombreUsual = '" + usuario.getNombre()+ "', " +
                "activo = " + usuario.getEstatus()+ ", " +
                "modificadoEl = getdate() " +
                 "WHERE id =  " + usuario.getId();
          
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(ModeloUsuario usuario) {
            strSql = "DELETE usuarios WHERE id = " + usuario.getId();
        
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public int loguear(String user, String pass) {
         int retorna =0;
          try {            
            strSql = " declare @vUsuario int" +
" exec usp_LoginUsuario '"+user+"','"+pass+"',@IdUsuario = @vUsuario output" +
" select @vUsuario" +
"";
              System.out.println(strSql);
            conexion.open();
            retorna = Integer.parseInt(conexion.onedato(strSql));                             
            
    
    
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return retorna;
    }
    
   
}
