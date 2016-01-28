package org.zhiyan.ria.dao;

import org.zhiyan.core.stereotype.DAO;
import org.zhiyan.persistence.dao.BaseDAO;
import org.zhiyan.ria.entity.User;

@DAO
public class UserDAO extends BaseDAO {

	public String getUser() {
		User user = new User();
		user.setAccount("test");
		user.setName("test");
		em.persist(user);
		return user.getId();
	}
}
