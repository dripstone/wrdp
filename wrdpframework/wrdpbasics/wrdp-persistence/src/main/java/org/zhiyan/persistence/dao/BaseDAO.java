package org.zhiyan.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDAO {
	@PersistenceContext
	protected EntityManager em;
}
