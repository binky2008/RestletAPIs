package com.milanix.logistics.api;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.milanix.logistics.api.resources.ContactsResource;
import com.milanix.logistics.api.resources.VersionResource;

/**
 * The main class that contains route to specific resources in this application
 * 
 * @author milan
 *
 */
public class LogisticsApplication extends Application {
	public static final String OAUTH_REALM = "api.logistics";

	@Override
	public Restlet createInboundRoot() {
		final Router router = new Router(getContext());
		router.attach("/", VersionResource.class);
		router.attach("/version", VersionResource.class);
		router.attach("/contacts", ContactsResource.class);
		router.attach("/contacts/{id}", ContactsResource.class);

		return router;
	}

}
