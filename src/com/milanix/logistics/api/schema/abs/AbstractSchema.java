package com.milanix.logistics.api.schema.abs;

import com.milanix.logistics.api.schema.specs.DatabaseRetrievable;

/**
 * This is an abstract definition of the response
 * 
 * @author milan
 * 
 */
public abstract class AbstractSchema<T, ID> implements DatabaseRetrievable<ID> {

	public static final String COL_ID = "id";

}