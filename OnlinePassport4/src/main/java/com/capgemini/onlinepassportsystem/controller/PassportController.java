package com.capgemini.onlinepassportsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinepassportsystem.entity.Passport;
import com.capgemini.onlinepassportsystem.exception.ResourceNotFoundException;
import com.capgemini.onlinepassportsystem.services.PassportService;


@RestController
@RequestMapping("/api/v1")
public class PassportController {
	
	private static final Logger logger = LogManager.getLogger(PassportController.class);
	
	@Autowired
	private PassportService passportRepository;
	
	@GetMapping("/getAllPassport")
    public List<Passport> getAllPassport(){
		logger.info("in passport controller of getAllPassport");
		logger.info("out passport controller of getAllPassport");
		
        return (List<Passport>) passportRepository.getAllPassport();
    }
}