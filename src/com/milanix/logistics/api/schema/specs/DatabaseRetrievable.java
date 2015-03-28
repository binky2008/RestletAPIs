package com.milanix.logistics.api.schema.specs;

/**
 * Interface to be implemented by schemas that is database retrievable
 * 
 * @author milan
 *
 * @param <T>
 */
public interface DatabaseRetrievable<T> {

	/**
	 * @return the id
	 */
	public T getId();

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(T id);

}
