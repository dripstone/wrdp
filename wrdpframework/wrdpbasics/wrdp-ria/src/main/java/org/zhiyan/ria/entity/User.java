package org.zhiyan.ria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.zhiyan.persistence.entity.BaseEntity;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	private static final long serialVersionUID = -8976970109206762011L;

	@Column(name = "user_account", length = 32)
	public String account;

	@Column(name = "user_name", length = 32)
	public String name;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
