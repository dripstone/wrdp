package org.zhiyan.user.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhiyan.user.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable> {

}
