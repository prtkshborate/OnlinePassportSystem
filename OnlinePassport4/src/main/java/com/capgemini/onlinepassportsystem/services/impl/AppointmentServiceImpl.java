package com.capgemini.onlinepassportsystem.services.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinepassportsystem.dao.AppointmentDao;
import com.capgemini.onlinepassportsystem.dao.PassportDao;
import com.capgemini.onlinepassportsystem.entity.Appointment;
import com.capgemini.onlinepassportsystem.entity.Passport;
import com.capgemini.onlinepassportsystem.exception.ResourceNotFoundException;
import com.capgemini.onlinepassportsystem.services.AppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private PassportDao passportDao;

	@Override
	public Iterable<Appointment> getAllAppointment() {
		return appointmentDao.findAll();
	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		
		List<Passport> passport = passportDao.findAll();
		for (int i = 0; i < passport.size(); i++) {
			if (passport.get(i).getP_type().equals("Normal")) {
				appointment.setDate(LocalDate.now().plusDays(8));
				appointment.setScheduleAppointmentStatus("schedule");
				appointment.setPassportId(passport.get(i).getId());
			} else if (passport.get(i).getP_type().equals("Tatkal")) {
				appointment.setDate(LocalDate.now().plusDays(2));
				appointment.setScheduleAppointmentStatus("schedule");
				appointment.setPassportId(passport.get(i).getId());
			}

		}
		return appointmentDao.save(appointment);
	}

	@Override
	public Appointment removeAppointment(Long appointmentId) throws ResourceNotFoundException {
		Appointment appointment = appointmentDao.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("appointment not found for this id"));

		appointmentDao.delete(appointment);
		return appointment;
	}

	@Override
	public Appointment findAppointmentById(Long appointmentId) {
		
		return appointmentDao.findById(appointmentId).get();
	}
	
	@Override
	public Appointment updateAppointmentById(Long appointmentId, String ScheduleStatus) {
		Appointment appointment = appointmentDao.findById(appointmentId).get();
		appointment.setScheduleAppointmentStatus(ScheduleStatus);
		
		return appointment;
	}
}
