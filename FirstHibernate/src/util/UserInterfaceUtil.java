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
	
	public static long promptAndGetLong(String message) {
		System.out.println(message);
		return new Scanner(System.in).nextLong();
	}
	
	public static double promptAndGetDouble(String message) {
		System.out.println(message);
		return new Scanner(System.in).nextDouble();
	}
}
