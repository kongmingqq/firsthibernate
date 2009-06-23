package util;

import java.util.Scanner;

public class UserInterfaceUtil {

	public static String promptAndGetString(String message) {
		System.out.println(message);
		return new Scanner(System.in).next();
	}
	
	public static int promptAndGetInt(String message) {
		System.out.println(message);
		return new Scanner(System.in).nextInt();
	}
}
