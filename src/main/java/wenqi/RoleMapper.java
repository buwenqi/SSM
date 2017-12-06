package wenqi;

import java.util.List;

/**
 * Created by buwenqi on 2017/12/5.
 */
public interface RoleMapper {
    public int insertRole(Role role);
    public int deleteRole(long id);
    public int updateRole(Role role);
    public Role getRole(long id);
    public List<Role> findRoles(String roleName);
}
