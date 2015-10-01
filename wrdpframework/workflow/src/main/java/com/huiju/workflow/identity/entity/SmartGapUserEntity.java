package com.huiju.workflow.identity.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.identity.Picture;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.db.HasRevision;
import org.activiti.engine.impl.db.PersistentObject;
import org.activiti.engine.impl.persistence.entity.ByteArrayRef;

public class SmartGapUserEntity implements Serializable, PersistentObject, HasRevision {

	private static final long serialVersionUID = -3954432890047244556L;

	protected String id;
	protected int revision;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;

	protected final ByteArrayRef pictureByteArrayRef = new ByteArrayRef();

	public SmartGapUserEntity() {
	}

	public SmartGapUserEntity(String id) {
		this.id = id;
	}

	public void delete() {
		Context.getCommandContext().getDbSqlSession().delete(this);

		deletePicture();
	}

	@Override
	public Object getPersistentState() {
		Map<String, Object> persistentState = new HashMap<String, Object>();
		persistentState.put("firstName", firstName);
		persistentState.put("lastName", lastName);
		persistentState.put("email", email);
		persistentState.put("password", password);
		persistentState.put("pictureByteArrayId", pictureByteArrayRef.getId());
		return persistentState;
	}

	@Override
	public int getRevisionNext() {
		return revision + 1;
	}

	public Picture getPicture() {
		if (pictureByteArrayRef.getId() != null) {
			return new Picture(pictureByteArrayRef.getBytes(), pictureByteArrayRef.getName());
		}
		return null;
	}

	public void setPicture(Picture picture) {
		if (picture != null) {
			savePicture(picture);
		} else {
			deletePicture();
		}
	}

	protected void savePicture(Picture picture) {
		pictureByteArrayRef.setValue(picture.getMimeType(), picture.getBytes());
	}

	protected void deletePicture() {
		pictureByteArrayRef.delete();
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int getRevision() {
		return revision;
	}

	@Override
	public void setRevision(int revision) {
		this.revision = revision;
	}

}
