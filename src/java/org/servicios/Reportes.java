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
import org.dao.DaoProductoTienda;
import org.modelos.ModeloProductoTienda;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "Reportes")
public class Reportes {
   private  DaoProductoTienda daoProdTienda = new DaoProductoTienda();
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ProductoTienda")
    public List ProductoTienda(@WebParam(name = "codtienda") int codtienda, @WebParam(name = "codprod") String codprod) {
        
        return daoProdTienda.produtoTienda(codtienda, codprod);
    }
}
