/*
infrateam and application team
 */
package com.amazonaws.saas.eks.util;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EksSaaSUtil {
	private static final Logger logger = LogManager.getLogger(EksSaaSUtil.class);

	public static String randomStr() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		logger.info("random generatedString=>" + generatedString);
		return generatedString;
	}
}
