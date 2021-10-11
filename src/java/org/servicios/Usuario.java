/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.servicios;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.dao.DaoUsuario;
import org.modelos.ModeloUsuario;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "Usuario")
public class Usuario {

 
 private  DaoUsuario daoUsuario = new DaoUsuario();
 
    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarUsuarios")
    public List listarUsuarios() {
        //TODO write your implementation code here:
        
        return daoUsuario.listartodos();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarUsuario")
    public ModeloUsuario listarUsuario(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return daoUsuario.listaruno(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarUsuario")
    public boolean eliminarUsuario(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
           ModeloUsuario user = new ModeloUsuario();
           user.setId(id);
        return daoUsuario.eliminar(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editarUsuario")
    public boolean editarUsuario(@WebParam(name = "id") int id, @WebParam(name = "idrol") int idrol, @WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password, @WebParam(name = "correo") String correo, @WebParam(name = "nombre") String nombre, @WebParam(name = "estatus") int estatus) {
          ModeloUsuario user = new ModeloUsuario();
        user.setId(id);
        user.setIdrol(idrol);
        user.setUsuario(usuario);
        user.setPassword(password);
        user.setCorreo(correo);
        user.setNombre(nombre);
        user.setEstatus(estatus);
    
       
        return daoUsuario.modificar(user);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarUsuario")
    public boolean insertarUsuario(@WebParam(name = "idrol") int idrol, @WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password, @WebParam(name = "correo") String correo, @WebParam(name = "nombre") String nombre, @WebParam(name = "estatus") int estatus) {
             ModeloUsuario user = new ModeloUsuario();
   
        user.setIdrol(idrol);
        user.setUsuario(usuario);
        user.setPassword(password);
        user.setCorreo(correo);
        user.setNombre(nombre);
        user.setEstatus(estatus);

       
        return daoUsuario.insertar(user);
    }
    
       @WebMethod(operationName = "IniciarSesion")
      public int loguear(@WebParam(name = "Correo") String Correo, @WebParam(name = "Clave") String Clave){

        return daoUsuario.loguear(Correo, Clave);
     }
     

}
