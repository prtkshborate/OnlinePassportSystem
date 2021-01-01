package com.capgemini.onlinepassportsystem.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.onlinepassportsystem.entity.Passport;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PassportDaoTest {

	@Autowired
	private PassportDao passportDao;

	@Autowired
	private TestEntityManager testEntityManager;


	@Test
	public void testGetAllPassport() throws Exception {
		Passport passport1 = new Passport();
		passport1.setId(2);
		passport1.setP_type("Tatkal");

		Passport passport2 = new Passport();
		passport2.setId(1);
			passport2.setP_type("Tatkal");

		testEntityManager.persist(passport1);
		testEntityManager.persist(passport2);
		
		List<Passport> passportList = (List<Passport>) passportDao.findAll();
		Assert.assertEquals(2, passportList.size());

	}

}
