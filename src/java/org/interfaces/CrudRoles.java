
package interfaces;

import java.util.List;
import modelo.ModelRoles;

/**
 *
 * @author MarcoVincio
 */
public interface CrudRoles {
    public List listar();
    public ModelRoles list (int id);    
    public boolean insertar(ModelRoles roles);
    public boolean modificar(ModelRoles roles);
    public boolean eliminar(int id);
}
