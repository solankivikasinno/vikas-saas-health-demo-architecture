/*
infrateam and application team
 */
package com.amazonaws.saas.eks.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingManager {
	private static final Logger logger = LogManager.getLogger(LogManager.class);

	public static void logDebug(String tenantId, String message) {
		logger.debug(tenantId + " => " + message);
	}

	public static void logInfo(String tenantId, String message) {
		logger.info(tenantId + " => " + message);
	}

	public static void logWarn(String tenantId, String message) {
		logger.warn(tenantId + " => " + message);
	}

	public static void logError(String tenantId, String message) {
		logger.error(tenantId + " => " + message);
	}
}
