package ar.edu.unq.sarmiento.utils;

import java.util.Optional;

public class Env {
	public static String getOrElse(String key, String defaultValue) {
		return read(key).orElse(defaultValue);
	}
	
	public static boolean isPresent(String key) {
		return read(key).isPresent();
	}
	
	private static Optional<String> read(String key) {
		return Optional.ofNullable(System.getenv(key));
	}
}
