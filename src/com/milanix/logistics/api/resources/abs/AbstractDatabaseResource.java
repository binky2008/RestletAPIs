package com.milanix.logistics.api.resources.abs;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.List;

import org.restlet.ext.gson.GsonRepresentation;
import org.restlet.representation.Representation;

import com.google.gson.JsonSyntaxException;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.milanix.logistics.api.schema.Contact;
import com.milanix.logistics.api.schema.abs.AbstractSchema;
import com.milanix.logistics.api.schema.specs.DatabaseRetrievable;

/**
 * An extension of {@link AbstractResource} that adds databse support
 * 
 * @author milan
 *
 * @param <T>
 *            schema type of the resource
 * @param <ID>
 *            id type of the resource
 */
public abstract class AbstractDatabaseResource<T extends DatabaseRetrievable<ID>, ID>
		extends AbstractResource<T, ID> {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/logistics";
	private static final String DATABASE_USER = "api";
	private static final String DATABASE_PASSWORD = "p@ssw0rd";

	private ConnectionSource connectionSource;
	private Dao<T, ID> dao;

	/**
	 * Returns a singleton instance of {@link ConnectionSource}
	 * 
	 * @return connection source
	 * @throws SQLException
	 */
	protected synchronized ConnectionSource getConnectionSource()
			throws SQLException {
		if (null == connectionSource)
			connectionSource = new JdbcConnectionSource(DATABASE_URL,
					DATABASE_USER, DATABASE_PASSWORD);

		return connectionSource;
	}

	/**
	 * Returns a singleton instance of {@link Dao<T,ID>}
	 * 
	 * @return the dao
	 */
	protected synchronized Dao<T, ID> getDao() throws SQLException {
		if (null == dao)
			dao = DaoManager.createDao(getConnectionSource(), getType());

		if (!dao.isTableExists())
			TableUtils.createTable(connectionSource, getType());

		return dao;
	}

	@Override
	public Representation read(final Representation representation) {
		try {
			final QueryBuilder<T, ID> queryBuilder = getDao().queryBuilder();

			if (null != getId())
				queryBuilder.where().eq(Contact.COL_ID, getId());

			return new GsonRepresentation<List<T>>(queryBuilder.query());
		} catch (Exception e) {
			return buildResponse(RESPONSE_REQUEST_FAILURE, e.getMessage());
		}
	}

	@Override
	public Representation create(final Representation representation) {
		try {
			final T object = new GsonRepresentation<T>(representation,
					getType()).getObject();

			if (null != object) {
				getDao().createOrUpdate(object);

				return new GsonRepresentation<T>(object);
			} else {
				throw new JsonSyntaxException(ERROR_JSON_SYNTAX);
			}
		} catch (Exception e) {
			return buildResponse(RESPONSE_REQUEST_FAILURE, e.getMessage());
		}
	}

	@Override
	public Representation update(final Representation representation) {
		try {
			final T object = new GsonRepresentation<T>(representation,
					getType()).getObject();

			if (null != getId())
				object.setId(getId());

			if (getDao().update(object) > 0)
				return new GsonRepresentation<T>(object);
			else
				throw new Exception(ERROR_REQUEST_UNKNOWN);
		} catch (Exception e) {
			return buildResponse(RESPONSE_REQUEST_FAILURE, e.getMessage());
		}
	}

	@Override
	public Representation delete(final Representation representation) {
		try {
			final DeleteBuilder<T, ID> deleteBuilder = getDao().deleteBuilder();
			deleteBuilder.where().eq(Contact.COL_ID, validateAndGetId());

			if (deleteBuilder.delete() > 0)
				return buildResponse(RESPONSE_REQUEST_SUCCESS, REQUEST_SUCCESS);
			else
				throw new Exception(ERROR_REQUEST_UNKNOWN);
		} catch (Exception e) {
			return buildResponse(RESPONSE_REQUEST_FAILURE, e.getMessage());
		}
	}

	/**
	 * Retrieves id and validates it exist
	 * 
	 * @return id if exist
	 * @throws Exception
	 *             if id is not passed or invalid or if it doesn't exit
	 */
	protected ID validateAndGetId() throws Exception {
		if (null == getId())
			throw new InvalidParameterException(ERROR_INVALID_ID);

		final QueryBuilder<T, ID> queryBuilder = getDao().queryBuilder();

		if (queryBuilder.where().eq(AbstractSchema.COL_ID, getId()).countOf() <= 0) {
			return getId();
		} else {
			throw new Exception(ERROR_NOT_FOUND);
		}
	}
}
