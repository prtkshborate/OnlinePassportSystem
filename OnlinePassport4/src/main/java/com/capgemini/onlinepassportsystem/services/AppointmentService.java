package com.capgemini.onlinepassportsystem.services;

import com.capgemini.onlinepassportsystem.entity.Appointment;
import com.capgemini.onlinepassportsystem.exception.ResourceNotFoundException;

public interface AppointmentService {
	
	Iterable<Appointment> getAllAppointment();
	
	Appointment findAppointmentById(Long appointmentId);

	Appointment removeAppointment(Long appointmentId) throws ResourceNotFoundException;
	
	Appointment createAppointment(Appointment appointment);
	
	Appointment updateAppointmentById(Long appointmentId,String ScheduleStatus);
	
}
