package com.milanix.logistics.api.resources.abs;

import org.restlet.data.Status;
import org.restlet.representation.Representation;

import com.milanix.logistics.api.schema.specs.DatabaseRetrievable;

/**
 * This class should be extended by resources that serves read only content
 * 
 * @author milan
 *
 */
public abstract class AbstractReadOnlyResource<T extends DatabaseRetrievable<ID>, ID>
		extends AbstractResource<T, ID> {

	@Override
	public Representation update(Representation representation) {
		doError(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);

		return null;
	}

	@Override
	public Representation create(Representation representation) {
		doError(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);

		return null;
	}

	@Override
	public Representation delete(Representation representation) {
		doError(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);

		return null;
	}

}