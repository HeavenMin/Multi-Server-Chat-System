package myServer2;

/*
 * AUTHOR : Min Gao
 * Project1-Multi-Server Chat System
 */

import java.util.regex.Pattern;

public class IdentityChecker {

	static Pattern validIdentity = Pattern.compile("^[a-zA-Z]\\w{2,15}$");

	public static boolean isIdentityValid(String identity) {
		return validIdentity.matcher(identity).find();
	}

}
