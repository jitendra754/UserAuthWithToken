package com.auth.demo.service;


import com.auth.demo.dao.UserDao;
import com.auth.demo.entity.User;
import com.auth.demo.entity.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
    	User user;
    	try{
        // Let people login with either username or email
        user = userDao.fetchUserByUserNameOrEmail(usernameOrEmail, usernameOrEmail);
                 
    	}catch(Exception e){
    		throw new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail);
    	}
        
        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
    	User user;
    	try{
    	
        	 user = userDao.fetchUserById(id.intValue());
        	
        }catch(Exception e){
         throw new UsernameNotFoundException("User not found with id : " + id);
        }

        return UserPrincipal.create(user);
    }
}

