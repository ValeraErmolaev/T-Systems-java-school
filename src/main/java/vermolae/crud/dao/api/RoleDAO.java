package vermolae.crud.dao.api;

import vermolae.exeptions.RoleNotFoundException;
import vermolae.model.Enum.Role;

public interface RoleDAO extends GenericDAO<Role, Integer> {
    public Role getRoleByName(String name) throws RoleNotFoundException;
}
