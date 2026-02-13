package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

	    public static String randomString() {
	        return RandomStringUtils.randomAlphabetic(5);
	    }

	    public static String randomNumeric() {
	        return RandomStringUtils.randomNumeric(10);
	    }

	    public static String alphaNumeric() {
	        return RandomStringUtils.randomAlphabetic(3)
	                + RandomStringUtils.randomNumeric(3);
	    }
	}


