package com.lpu.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lpu.blog.payloads.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateuser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userid);
	
	

}
