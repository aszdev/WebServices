/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.modelos.ModeloUsuario;
/**
 *
 * @author Administrador
 */
public interface CrudUsuario {
    
    public List listartodos();
    public ModeloUsuario listaruno (int id);
    public boolean insertar(ModeloUsuario usuario);
    public boolean modificar(ModeloUsuario usuario);
    public boolean eliminar(ModeloUsuario usuario);
    public int loguear(String user, String pass);
}
