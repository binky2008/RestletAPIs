package com.milanix.logistics.api.utils;

import org.restlet.engine.util.StringUtils;

/**
 * Helper class containing utility to parse string to numbers
 *
 * @author Milan
 */
public class NumberHelper {
	/**
	 * This method will parse string to integer.
	 *
	 * @param string
	 *            to be parsed
	 * @return parse value or 0 if there's an exception
	 */
	public static int getInteger(String string) {
		return getIntegerObject(string) == null ? 0 : getIntegerObject(string);
	}

	/**
	 * This method will parse string to integer.
	 *
	 * @param string
	 *            to be parsed
	 * @return parse value or null if there's an exception
	 */
	public static Integer getIntegerObject(String string) {
		if (StringUtils.isNullOrEmpty(string)) {
			return null;
		}

		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * This method will parse string to long.
	 *
	 * @param string
	 *            to be parsed
	 * @return parse value or 0 if there's an exception
	 */
	public static long getLong(String string) {
		return getLongObject(string) == null ? 0l : getLongObject(string);
	}

	/**
	 * This method will parse string to long.
	 *
	 * @param string
	 *            to be parsed
	 * @return parse value or null if there's an exception
	 */
	public static Long getLongObject(String string) {
		if (StringUtils.isNullOrEmpty(string)) {
			return null;
		}

		try {
			return Long.parseLong(string);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * This method will parse string to double.
	 *
	 * @param string
	 *            to be parsed
	 * @return parse value or 0 if there's an exception
	 */
	public static double getDouble(String string) {
		return getDoubleObject(string) == null ? 0.0d : getDoubleObject(string);
	}

	/**
	 * This method will parse string to double.
	 *
	 * @param string
	 *            to be parsed
	 * @return parse value or null if there's an exception
	 */
	public static Double getDoubleObject(String string) {
		if (StringUtils.isNullOrEmpty(string)) {
			return null;
		}
		try {

			return Double.parseDouble(string);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * This method will parse string to float.
	 *
	 * @param string
	 *            to be parsed
	 * @return parse value or 0 if there's an exception
	 */
	public static float getFloat(String string) {
		return getFloatObject(string) == null ? 0.0f : getFloatObject(string);
	}

	/**
	 * This method will parse string to float.
	 *
	 * @param string
	 *            to be parsed
	 * @return parse value or null if there's an exception
	 */
	public static Float getFloatObject(String string) {
		if (StringUtils.isNullOrEmpty(string)) {
			return null;
		}
		try {

			return Float.parseFloat(string);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
