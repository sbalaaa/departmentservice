package com.training.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.exceptions.ClientErrorException;
import com.training.vo.LoginVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Validated
@Slf4j
public class LoginController {
	
	@PostMapping("/login")
	@CrossOrigin(origins="*", maxAge = 3600)
    public ResponseEntity<LoginVO> checkValidUser(@Valid @RequestBody LoginVO vo) {
		log.info("checkValidUser begin");
    	if(vo.getUserName().equals("admin") && vo.getPassword().equals("password")) {
    		vo.setStatus("SUCCESS");
    		return new ResponseEntity<LoginVO>(vo,HttpStatus.OK);
    	} else {
    		throw new ClientErrorException("User Name and Password is not valid");
    	}

	 	
	}

}
