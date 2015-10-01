package com.huiju.workflow.identity;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;

import com.huiju.workflow.identity.impl.SmartGapUserEntityManager;

public class SmartGapUserEntityManagerFactory implements SessionFactory {

	@Override
	public Class<?> getSessionType() {
		return SmartGapUserEntityManager.class;
	}

	@Override
	public Session openSession() {
		return new SmartGapUserEntityManager();
	}

}
