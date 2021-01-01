package com.capgemini.onlinepassportsystem.services;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.onlinepassportsystem.dao.PassportDao;
import com.capgemini.onlinepassportsystem.entity.Passport;
import com.capgemini.onlinepassportsystem.exception.ResourceNotFoundException;
import com.capgemini.onlinepassportsystem.services.PassportService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassportServiceTest {

	@MockBean
	private PassportDao passportDao;

	@Autowired
	private PassportService passportService;

	@Test
	public void testGetAllPassport() {
		Passport passport1 = new Passport();
		passport1.setId(6);
		passport1.setP_type("Tatkal");

		Passport passport2 = new Passport();
		passport2.setId(7);
		passport2.setP_type("Normal");

		List<Passport> passportList = new ArrayList<>();
		passportList.add(passport1);
		passportList.add(passport2);

		Mockito.when(passportDao.findAll()).thenReturn(passportList);
		assertThat(passportService.getAllPassport()).isEqualTo(passportList);
	}


}
