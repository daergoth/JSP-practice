package net.daergoth.data;

import java.util.Arrays;
import java.util.List;

import net.daergoth.model.User;

public class UserDaoMock implements UserDao {
	
	private static final List<User> users = Arrays.asList(
			new User("email1@example.com", "password1"),
			new User("email2@example.com","password2"),
			new User("email3@example.com", "password3")
	);

	public List<User> getAllUsers() {
		return users;
	}

	public User getUserByEmail(String email) {
		for (User u : users) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}
		
		return null;
	}

}
