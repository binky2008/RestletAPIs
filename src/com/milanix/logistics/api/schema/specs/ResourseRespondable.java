package com.milanix.logistics.api.schema.specs;

/**
 * Interface to be implemented by classes which returns result and message
 * instead of {@link Representation}
 * 
 * @author milan
 * @param<T> type of the result
 *
 */
public interface ResourseRespondable<T> {

	/**
	 * @return the result
	 */
	public abstract T getResult();

	/**
	 * @param result
	 *            the result to set
	 */
	public abstract void setResult(T result);

	/**
	 * @return the message
	 */
	public abstract String getMessage();

	/**
	 * @param message
	 *            the message to set
	 */
	public abstract void setMessage(String message);

}