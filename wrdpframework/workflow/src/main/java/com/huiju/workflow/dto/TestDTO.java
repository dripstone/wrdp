package com.huiju.workflow.dto;

import java.io.Serializable;

public class TestDTO implements Serializable {

	private static final long serialVersionUID = 6727697714228852442L;

	public String businessID;
	public String businessName;
	public String wfDefinitionID;
	public String userAccount;

	public String getBusinessID() {
		return businessID;
	}

	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getWfDefinitionID() {
		return wfDefinitionID;
	}

	public void setWfDefinitionID(String wfDefinitionID) {
		this.wfDefinitionID = wfDefinitionID;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
}
