
package org.servicios;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import dao.DaoRoles;
import modelo.ModelRoles;


/**
 *
 * @author MarcoVincio
 */
@WebService(serviceName = "Rol")
public class Rol {

   
   
    @WebMethod(operationName = "IngreseRol")
    public Boolean IngreseRol(
         
            @WebParam(name = "name") String nombre
    ) {
        ModelRoles roles = new ModelRoles();
        DaoRoles daoRoles = new DaoRoles();

        roles.setNombre(nombre);
        return daoRoles.insertar(roles);
    }
    
    @WebMethod(operationName = "MostrarRoles")
    public List<ModelRoles> MostrarRoles() {
        DaoRoles daoRoles = new DaoRoles();
        return daoRoles.listar();
    }
    
    @WebMethod(operationName = "Modificarrol")
    public Boolean ModificarRol(
            @WebParam(name = "id") int idRol,
            @WebParam(name = "name") String nombre

    ) {
        ModelRoles roles = new ModelRoles();
        DaoRoles daoRoles = new DaoRoles();
        roles.setIdRol(idRol);
        roles.setNombre(nombre);
        return daoRoles.modificar(roles);
    }
    
    @WebMethod(operationName = "SuprimirProducto")
    public boolean SuprimirProducto(@WebParam(name = "id") int idRol) {
        DaoRoles daoRoles = new DaoRoles();
        return daoRoles.eliminar(idRol);
    }
   
 @WebMethod(operationName = "VerRoles")
    public ModelRoles VerRoles(@WebParam(name = "id") Integer idRol) {
        DaoRoles daoRoles = new DaoRoles();
        return daoRoles.list(idRol);
    }

}
