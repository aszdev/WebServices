/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.modelos.ModeloTienda;

/**
 *
 * @author MarcoVincio
 */
public interface CrudTienda {
    public List listar();
    public ModeloTienda list (int IdTienda);    
    public boolean obtener(ModeloTienda tienda);

    
}
