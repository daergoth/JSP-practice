package net.daergoth.data;

import java.util.List;

import net.daergoth.model.User;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUserByEmail(String email);

}
