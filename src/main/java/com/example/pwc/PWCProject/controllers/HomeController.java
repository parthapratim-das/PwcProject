package com.example.pwc.PWCProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pwc.PWCProject.models.UserDTO;
import com.example.pwc.PWCProject.service.UserService;


@RestController
@RequestMapping(path = "/user")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<UserDTO> getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}

}
