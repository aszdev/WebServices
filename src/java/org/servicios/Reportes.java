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
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.dao.DaoProductoTienda;
import org.dao.DaoReporteVenta;
import org.dao.DaoTienda;
import org.modelos.ModeloProductoTienda;
import org.modelos.ModeloReporteVenta;
import org.modelos.ModeloTienda;

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
    public List<ModeloProductoTienda> ProductosTienda(@WebParam(name = "tienda") int tienda, @WebParam(name = "codigo") String codigo) {
        DaoProductoTienda daoprod = new DaoProductoTienda();
        return daoprod.produtoTienda(0, "");
    }
      /**
     * Web service operation
     */
     @WebMethod(operationName = "ListadoTiendas")
   public List<ModeloTienda> list() {
        DaoTienda daoTienda = new DaoTienda();
        return daoTienda.listar();
    }

       /**
     * This is a sample web service operation
     */
 
    
        @WebMethod(operationName = "ReporteVenta")
      public List<ModeloReporteVenta> ListarReporte(@WebParam(name = "FechaInicio") String fechaInc, @WebParam(name = "FechaFinal") String fecha_fin, @WebParam(name = "TiendaID") int tienda){
        DaoReporteVenta daoR = new DaoReporteVenta();
        return daoR.ListarReporte(fechaInc, fecha_fin, tienda);
     }

}
