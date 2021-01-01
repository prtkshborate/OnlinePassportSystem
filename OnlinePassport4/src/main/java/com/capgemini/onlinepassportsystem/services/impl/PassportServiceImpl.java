package com.capgemini.onlinepassportsystem.services.impl;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinepassportsystem.dao.PassportDao;
import com.capgemini.onlinepassportsystem.entity.Passport;
import com.capgemini.onlinepassportsystem.exception.ResourceNotFoundException;
import com.capgemini.onlinepassportsystem.services.PassportService;

@Service
@Transactional
public class PassportServiceImpl implements PassportService {

	@Autowired 
	private PassportDao passportDao;

	@Override
	public Iterable<Passport> getAllPassport() {
		return passportDao.findAll();
	}

}
