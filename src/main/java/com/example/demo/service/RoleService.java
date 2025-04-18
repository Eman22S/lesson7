package com.example.demo.service;



import com.example.demo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role createRole(Role role);
    void deleteRole(Long id);
}
