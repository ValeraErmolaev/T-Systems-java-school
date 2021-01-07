package vermolae.crud.dao.api;

import vermolae.model.entity.Role;
import vermolae.exeptions.RoleNotFoundException;

public interface RoleDAO extends GenericDAO<Role, Integer> {
    public Role getRoleByName(String name) throws RoleNotFoundException;
}
