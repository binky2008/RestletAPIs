package com.milanix.logistics.api.resources.abs;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.milanix.logistics.api.schema.specs.DatabaseRetrievable;

/**
 * This class should be extended by all class providing
 * {@link org.restlet.resource.ServerResource}
 * 
 * @author milan
 * @param <T>
 *            type of the schema
 * @param <ID>
 *            type of the schema id
 *
 */
public abstract class AbstractResource<T extends DatabaseRetrievable<ID>, ID>
		extends ServerResource {
	protected static final int RESPONSE_REQUEST_SUCCESS = 1;
	protected static final int RESPONSE_REQUEST_FAILURE = 2;

	protected static final String REQUEST_SUCCESS = "success";
	protected static final String ERROR_INVALID_ID = "invalid id";
	protected static final String ERROR_INVALID_PARAMETER = "invalid parameters";
	protected static final String ERROR_REQUEST_UNKNOWN = "request failure";
	protected static final String ERROR_JSON_SYNTAX = "failed to parse request";
	protected static final String ERROR_NOT_FOUND = "resource not found";

	/**
	 * Returns type of this resource
	 * 
	 * @return type
	 */
	protected abstract Class<T> getType();

	/**
	 * Returns id of this resource
	 * 
	 * @return id
	 */
	protected abstract ID getId();

	/**
	 * Called when HTTP get method is called in this resource
	 * 
	 * @param representation
	 *            posted
	 * @return representation to return
	 */
	@Get
	public abstract Representation read(final Representation representation);

	/**
	 * Called when HTTP post method is called in this resource
	 * 
	 * @param representation
	 *            posted
	 * @return representation to return
	 */
	@Post
	public abstract Representation create(final Representation representation);

	/**
	 * Called when HTTP put method is called in this resource
	 * 
	 * @param representation
	 *            posted
	 * @return representation to return
	 */
	@Put
	public abstract Representation update(final Representation representation);

	/**
	 * Called when HTTP delete method is called in this resource
	 * 
	 * @param representation
	 *            posted
	 * @return representation to return
	 */
	@Delete
	public abstract Representation delete(final Representation representation);

	/**
	 * Builds up an error
	 * 
	 * @param result
	 *            error code
	 * @param message
	 *            error message
	 * @return
	 */
	protected Representation buildResponse(Integer result, String message) {
		try {
			final JSONObject error = new JSONObject();
			error.put("result", result);
			error.put("message", message);

			return new JsonRepresentation(error);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new StringRepresentation(ERROR_REQUEST_UNKNOWN);
	}

}
