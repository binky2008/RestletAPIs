package com.milanix.logistics.api.resources;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource containing API version info
 * 
 * @author milan
 *
 */
public class VersionResource extends ServerResource {
	private static final String VERSION_APPLICATION = "application";
	private static final String VERSION_CODE = "versionCode";
	private static final String VERSION_NAME = "versionName";

	@Get
	public Representation readVersionInfo() {
		final JSONObject version = new JSONObject();

		try {
			version.put(VERSION_APPLICATION, "Logistics");
			version.put(VERSION_CODE, "0.0.1");
			version.put(VERSION_NAME, "Gokyo Ri");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new JsonRepresentation(version);
	}

}
