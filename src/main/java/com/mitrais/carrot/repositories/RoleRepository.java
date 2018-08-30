package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByRoleName(String roleName);
}
