/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.modelos.ModeloReporteVenta;

/**
 *
 * @author MarcoVincio
 */
public interface CrudReporteVenta {
      
        public List ListarReporte (String fechaInc, String fecha_fin, int tienda);
}
