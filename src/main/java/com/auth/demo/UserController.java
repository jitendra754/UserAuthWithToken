package com.auth.demo;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.demo.entity.JwtAuthenticationResponse;
import com.auth.demo.entity.User;
import com.auth.demo.security.JwtTokenProvider;
import com.auth.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    JwtTokenProvider tokenProvider;
	
	@Autowired
    AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody User loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

	
	@PostMapping("/createUser")
	public Map<String,Object> createUser(@RequestBody User applicationUser){
		applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
		Map<String,Object> map = new HashMap<String, Object>();
		try{
		User user = userService.createUser(applicationUser);
		//return new ResponseEntity<>(userService.createUser(applicationUser), HttpStatus.OK);
		map.put("data",user);
		
		map.put("status",HttpStatus.OK);
		map.put("message","Data Saved Sucessfully!!");
		}catch(Exception e){
			map.put("status",HttpStatus.NOT_ACCEPTABLE);	
			map.put("message","Error occurred during user Creation");
		//return new ResponseEntity<>("Not Sucessfully Created!!", HttpStatus.BAD_REQUEST);	
		}
		return map;
		
	}
	
	@GetMapping("/userList")
	public String getUserList(){
		
		return "xyz";
	}

}
