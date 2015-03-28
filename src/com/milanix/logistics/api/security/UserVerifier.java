package com.milanix.logistics.api.security;

import java.sql.SQLException;
import java.util.List;

import org.restlet.security.SecretVerifier;

import com.j256.ormlite.dao.Dao;
import com.milanix.logistics.api.schema.User;

/**
 * This is a custom verifier to verify user account
 * 
 * @author milan
 * 
 */
public class UserVerifier extends SecretVerifier {

	private Dao<User, String> userDao;

	@Override
	public int verify(String identifier, char[] secret) {
		if (null != userDao) {
			try {
				final List<User> users = userDao.queryBuilder().where()
						.eq(User.COL_USERNAME, identifier)
						.eq(User.COL_PASSWORD, new String(secret)).query();

				if (!users.isEmpty())
					return SecretVerifier.RESULT_VALID;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return SecretVerifier.RESULT_UNKNOWN;
	}
}
