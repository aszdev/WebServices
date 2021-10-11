
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import interfaces.CrudRoles;
import modelo.ModelRoles;


/**
 *
 * @author MarcoVincio
 */
public class DaoRoles implements CrudRoles {

    String strSql =  "";
    Conexion conexion = new Conexion();
    ResultSet rs = null;
    boolean respuesta = false;
    
    @Override
    public List listar() {
         List<ModelRoles>lstRoles = new ArrayList<>();
         try {            
            strSql = "select * from dbo.roles";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            System.out.println("StrSql: " + strSql);
            while (rs.next()) {
                ModelRoles roles = new ModelRoles();
                roles.setIdRol(rs.getInt("id"));
                roles.setNombre(rs.getString("name"));
                lstRoles.add(roles);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRoles.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoRoles.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstRoles;
    }

    @Override
    public ModelRoles list(int id) {
                ModelRoles roles = new ModelRoles();
         try {           
            strSql = "SELECT * FROM dbo.roles  WHERE id = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                            
            System.out.println("StrSql: " + strSql);
            while (rs.next()) {
                roles.setIdRol(rs.getInt("id"));
                roles.setNombre(rs.getString("name"));
            
            }
            rs.close();
            conexion.close();
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoRoles.class.getName()).log(Level.SEVERE, null, ex);           
        } catch(Exception ex){
            Logger.getLogger(DaoRoles.class.getName()).log(Level.SEVERE, null, ex);           
        }
       
        return roles;
    }

    @Override
    public boolean insertar(ModelRoles roles) {
               strSql = "INSERT INTO dbo.roles(name)VALUES" + 
                "('"  + roles.getNombre()+"')";
             
                System.out.println("StrSql: " + strSql);
        try {
            conexion.open();
            respuesta = conexion.executeSql(strSql);
            conexion.close();
        } catch (Exception e) {
             Logger.getLogger(DaoRoles.class.getName()).log(Level.SEVERE, null, e);            
        
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelRoles roles) {
            strSql = "UPDATE dbo.roles " +
                 "SET name             = '" + roles.getNombre() + "'"
                 + " WHERE id = " + roles.getIdRol();
            
                 System.out.println("StrSql: " + strSql);
       
        try{
            conexion.open();
            respuesta = conexion.executeSql(strSql);
            conexion.close();
        }catch(Exception ex){
            Logger.getLogger(DaoRoles.class.getName()).log(Level.SEVERE, null, ex);           
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
       strSql = "DELETE FROM dbo.roles WHERE id = " + id;
          System.out.println("StrSql: " + strSql);
        try {
            conexion.open();
            respuesta = conexion.executeSql(strSql);
            conexion.close();
        } catch (Exception e) {
            Logger.getLogger(DaoRoles.class.getName()).log(Level.SEVERE, null, e);                  
        }
        return respuesta;
    }
    
}
