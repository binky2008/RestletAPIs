package com.milanix.logistics.api.resources;

import com.milanix.logistics.api.resources.abs.AbstractDatabaseResource;
import com.milanix.logistics.api.schema.Contact;
import com.milanix.logistics.api.schema.abs.AbstractSchema;
import com.milanix.logistics.api.utils.NumberHelper;

/**
 * Resource containing contacts info
 * 
 * @author milan
 *
 */
public class ContactsResource extends
		AbstractDatabaseResource<Contact, Integer> {

	@Override
	protected Class<Contact> getType() {
		return Contact.class;
	}

	@Override
	protected Integer getId() {
		return NumberHelper.getIntegerObject((String) getRequestAttributes()
				.get(AbstractSchema.COL_ID));
	}

}
