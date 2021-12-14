package web.service;

import web.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {
    void createRole(Role role);
    List<Role> getAllRoles();
    Role getRoleByName(String name);
    HashSet<Role> getSetOfRoles(String[] roleNames);
}
