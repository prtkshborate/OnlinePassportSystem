package com.capgemini.onlinepassportsystem.dao;



import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.onlinepassportsystem.entity.Appointment;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentDaoTest {

	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void testCreateAppointment() throws Exception {
		Appointment appointment1 = getAppointment();
		Appointment saveInDB = testEntityManager.persist(appointment1);
		Appointment getFromDB = appointmentDao.findById(saveInDB.getAppointmentId()).get();
		assertThat(getFromDB).isEqualTo(saveInDB);
	}

	private Appointment getAppointment() {
		Appointment appointment = new Appointment();
	
		appointment.setDate(LocalDate.now());
		appointment.setPassportId(1);
		appointment.setScheduleAppointmentStatus("Schedule");
		return appointment;
	}
	
	@Test
	public void testGetAllAppointment() throws Exception
	{
		Appointment appointment1 = new Appointment();
		appointment1.setDate(LocalDate.now());
		appointment1.setPassportId(1);
		appointment1.setScheduleAppointmentStatus("Schedule");
	
		Appointment appointment2 = new Appointment();
		appointment2.setDate(LocalDate.now());
		appointment2.setPassportId(2);
		appointment2.setScheduleAppointmentStatus("Schedule");
		
		testEntityManager.persist(appointment1);
		testEntityManager.persist(appointment2);
		
		List<Appointment> appointmentList = (List<Appointment>) appointmentDao.findAll();
		Assert.assertEquals(2,appointmentList.size());
		
		
	}
	@Test
	public void removeAppointment()
	{
		Appointment appointment1 = new Appointment();
		appointment1.setDate(LocalDate.now());
		appointment1.setPassportId(1);
		appointment1.setScheduleAppointmentStatus("Schedule");
	
		Appointment appointment2 = new Appointment();
		appointment2.setDate(LocalDate.now());
		appointment2.setPassportId(2);
		appointment2.setScheduleAppointmentStatus("Schedule");
		
		Appointment appointment = testEntityManager.persist(appointment1);
		testEntityManager.persist(appointment2);
		
		testEntityManager.remove(appointment);
		List<Appointment> appointmentList = (List<Appointment>) appointmentDao.findAll();
		Assert.assertEquals(appointmentList.size(), 1);
		
	}
	
	@Test
	public void testUpdateAppointment()
	{
		Appointment appointment = new Appointment();
		
		appointment.setAppointmentId(101);
		appointment.setDate(LocalDate.now());
		appointment.setPassportId(1);
		appointment.setScheduleAppointmentStatus("Schedule");
		
		try
		{
		testEntityManager.persist(appointment);
		Appointment getFromDB = appointmentDao.findByscheduleAppointmentStatus("Schedule");
		getFromDB.setScheduleAppointmentStatus("NotSchedule");
		
		testEntityManager.persist(getFromDB);
		assertThat(getFromDB.getScheduleAppointmentStatus()).isEqualTo("NotSchedule");
		}catch(Exception e) {}
		
	}
	
}
