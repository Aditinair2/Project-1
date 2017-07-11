package com.niit.dao;
import java.util.List;

import com.niit.model.User;
import com.niit.model.UserDetail;



public interface UserDetailDao {

   public void addUser (UserDetail usersDetail);

   public UserDetail getUserById (int userId);

   public List<UserDetail> getAllUsers();

//    UserDetail getUserByUsername (String username);
    User getUserByUsername(String username);
    public boolean isValidUser(String name, String password);
}
