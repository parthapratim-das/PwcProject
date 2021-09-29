package com.example.pwc.PWCProject.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pwc.PWCProject.models.User;
import com.example.pwc.PWCProject.models.UserDTO;
import com.example.pwc.PWCProject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public UserDTO getUsers() {
		UserDTO userDto = new UserDTO();
		User user;
		List<User> userList = new ArrayList<>();
		Object result = restTemplate.getForObject("https://gorest.co.in/public/v1/users", Object.class);
		LinkedHashMap<Object, Object> content = (LinkedHashMap<Object, Object>) result;
		List<Object> objects = (List<Object>) content.get("data");
		for(Object obj : objects) {
			ObjectMapper mapper = new ObjectMapper();
			user = mapper.convertValue(obj, User.class);
			userList.add(user);
		}
		userDto.setUsers(userList);
		return userDto;
	}

}
