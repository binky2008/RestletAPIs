package com.milanix.logistics.api.schema;

import com.j256.ormlite.field.DatabaseField;
import com.milanix.logistics.api.schema.abs.AbstractSchema;

/**
 * This is an user dao
 * 
 * @author milan
 * 
 */
public class User extends AbstractSchema<User, Integer> {

	public static final String COL_USERNAME = "username";
	public static final String COL_PASSWORD = "password";

	@DatabaseField(generatedId = true, columnName = COL_ID)
	protected Integer id;

	@DatabaseField(canBeNull = false, columnName = COL_USERNAME)
	private String name;

	@DatabaseField(canBeNull = false, columnName = COL_PASSWORD)
	private String password;

	/**
	 * This is a default constructor for orm call
	 */
	public User() {
	}

	/**
	 * This is a default constructor for instantiating the object
	 * 
	 * @param name
	 * @param password
	 */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}