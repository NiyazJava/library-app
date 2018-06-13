package com.javarnd.lib;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
	private static UserDao instance;
	private Map<String, String> userRepository = new HashMap<String, String>();

	private UserDao() {
		// no-arg constructor
	}

	public void addUser(UserCredential user) {
		userRepository.put(user.getUsername(), user.getPassword());
	}

	public boolean validateUser(UserCredential user) {
		return userRepository.containsKey(user.getUsername())
				? user.getPassword().equals(userRepository.get(user.getUsername())) : false;
	}

	public static UserDao getInstance() {
		if (instance == null) {
			synchronized (UserDao.class) {
				if (instance == null) {
					instance = new UserDao();
				}
			}
		}
		return instance;
	}
}
