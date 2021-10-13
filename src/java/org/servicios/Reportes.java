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

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "Reportes")
public class Reportes {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ProductosTienda")
    public List ProductosTienda(@WebParam(name = "tienda") int tienda, @WebParam(name = "codigo") String codigo) {
        DaoProductoTienda daoprod = new DaoProductoTienda();
        return daoprod.produtoTienda(tienda, codigo);
    }


}
