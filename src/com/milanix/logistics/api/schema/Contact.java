package com.milanix.logistics.api.schema;

import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.milanix.logistics.api.schema.abs.AbstractSchema;

/**
 * This is an contact dao
 * 
 * @author milan
 * 
 */
@DatabaseTable(tableName = "contacts")
public class Contact extends AbstractSchema<Contact, Integer> {
	public static final String COL_FIRSTNAME = "firstname";
	public static final String COL_LASTNAME = "lastname";
	public static final String COL_NUMBER = "number";
	public static final String COL_ADDRESS = "address";

	@DatabaseField(generatedId = true, columnName = COL_ID)
	protected Integer id;

	@DatabaseField(canBeNull = false, columnName = COL_FIRSTNAME)
	@Expose
	private String firstname;

	@DatabaseField(canBeNull = false, columnName = COL_LASTNAME)
	@Expose
	private String lastname;

	@DatabaseField(canBeNull = false, columnName = COL_NUMBER)
	@Expose
	private String number;

	@DatabaseField(canBeNull = false, columnName = COL_ADDRESS)
	@Expose
	private String address;

	/**
	 * This is a default constructor for orm call
	 */
	public Contact() {
	}

	public Contact(Integer id, String firstname, String lastname,
			String number, String address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.number = number;
		this.address = address;
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
