package org.zhiyan.ria.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.zhiyan.core.stereotype.BO;
import org.zhiyan.ria.dao.UserDAO;

@BO
public class UserBO {
	@Autowired
	UserDAO userDAO;

	public String sayHello() {
		String id = userDAO.getUser();
		return id + "hello world!";
	}
}
