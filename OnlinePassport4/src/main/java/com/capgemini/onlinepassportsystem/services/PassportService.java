package com.capgemini.onlinepassportsystem.services;

import com.capgemini.onlinepassportsystem.entity.Passport;
import com.capgemini.onlinepassportsystem.exception.ResourceNotFoundException;

public interface PassportService {

	Iterable<Passport> getAllPassport();
	
	}
 