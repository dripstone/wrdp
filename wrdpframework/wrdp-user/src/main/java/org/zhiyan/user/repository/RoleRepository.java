package org.zhiyan.user.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhiyan.user.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable> {

}
