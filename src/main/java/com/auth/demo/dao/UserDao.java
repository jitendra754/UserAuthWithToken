package com.auth.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.auth.demo.entity.User;

@Repository("userDao")
public interface UserDao extends CrudRepository<User, Integer> {

	public User fetchUserByUserNameOrEmail(String username, String email);
	
	public User fetchUserById(int id);

}
