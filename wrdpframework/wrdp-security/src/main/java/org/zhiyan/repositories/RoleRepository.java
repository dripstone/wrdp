package org.zhiyan.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zhiyan.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{



}
