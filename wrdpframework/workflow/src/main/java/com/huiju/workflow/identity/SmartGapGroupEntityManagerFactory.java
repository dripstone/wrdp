package com.huiju.workflow.identity;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;

import com.huiju.workflow.identity.impl.SmartGapGroupEntityManager;

public class SmartGapGroupEntityManagerFactory implements SessionFactory {

	@Override
	public Class<?> getSessionType() {
		return SmartGapGroupEntityManager.class;
	}

	@Override
	public Session openSession() {
		return new SmartGapGroupEntityManager();
	}

}
