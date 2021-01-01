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

import com.capgemini.onlinepassportsystem.dao.AppointmentDao;
import com.capgemini.onlinepassportsystem.entity.Appointment;
import com.capgemini.onlinepassportsystem.entity.Passport;
import com.capgemini.onlinepassportsystem.services.AppointmentService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceTest {

	@MockBean
	private AppointmentDao appointmentDao;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Test
	public void testGetAllAppointment()
	{
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setDate(LocalDate.now());
		appointment.setPassportId(10);
		appointment.setScheduleAppointmentStatus("Schedule");
		
		Appointment appointment1 = new Appointment();
		appointment1.setAppointmentId(2);
		appointment1.setDate(LocalDate.now());
		appointment1.setPassportId(12);
		appointment1.setScheduleAppointmentStatus("Not Schedule");
		
		List<Appointment> appointmentList = new ArrayList<>();
		appointmentList.add(appointment);
		appointmentList.add(appointment1);
		
		Mockito.when(appointmentDao.findAll()).thenReturn(appointmentList);
		assertThat(appointmentService.getAllAppointment()).isEqualTo(appointmentList);
		
	}
	
	@Test
	public void testCreateAppointment()
	{
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setDate(LocalDate.now());
		appointment.setPassportId(10);
		appointment.setScheduleAppointmentStatus("Schedule");
	
		Mockito.when(appointmentDao.save(appointment)).thenReturn(appointment);
		assertThat(appointmentService.createAppointment(appointment)).isEqualTo(appointment);
		
	}
	
	@Test
	public void testFindAppointmentById()
	{
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(2);
		appointment.setDate(LocalDate.now());
		appointment.setPassportId(12);
		appointment.setScheduleAppointmentStatus("Schedule");
		try
		{
		Appointment ap = appointmentDao.findById((long) 2).get();
		Mockito.when(ap).thenReturn(appointment);
		assertThat(appointmentService.findAppointmentById((long) 2)).isEqualTo(appointment);
		}
		catch(Exception e) {}
	}
	
	@Test
	public void testRemoveAppointment()
	{
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(2);
		appointment.setDate(LocalDate.now());
		appointment.setPassportId(12);
		appointment.setScheduleAppointmentStatus("Schedule");
		
		try
		{
			Mockito.when(appointmentDao.save(appointment)).thenReturn(appointment);
			Mockito.when(appointmentDao.findById((long) 2).get()).thenReturn(appointment);
			appointmentDao.deleteById(appointment.getAppointmentId());
			Mockito.when(appointmentDao.findById((long) 2).get()).thenReturn(appointment);
			Assert.assertNotEquals(appointment, new Passport());
			Assert.assertEquals(appointmentService.removeAppointment((long) 2), false);
		}
		catch(Exception e) {}
	}
	
	@Test
	public void updateAppointmentById()
	{
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(101);
		appointment.setDate(LocalDate.now());
		appointment.setPassportId(1);
		appointment.setScheduleAppointmentStatus("Schedule");
		
		try
		{
			Mockito.when(appointmentDao.findById((long) 101).get()).thenReturn(appointment);
			appointment.setScheduleAppointmentStatus("NotSchedule");
			Mockito.when(appointmentDao.save(appointment)).thenReturn(appointment);
			
			assertThat(appointmentService.updateAppointmentById((long)101,"NotSchedule")).isEqualTo(appointment);
		}
			catch(Exception e) {}
	}
		
}
