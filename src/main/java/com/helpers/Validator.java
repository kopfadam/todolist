package com.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean validatePassword(String password) {
		int minLength = 6;
        int maxLength = 16;
        StringBuilder patternBuilder = new StringBuilder("((?=.*[a-z])");
        patternBuilder.append(".{" + minLength + "," + maxLength + "})");
        String regex = patternBuilder.toString();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        return m.matches();
	}

	public static boolean validateEmail(String email) {

		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
