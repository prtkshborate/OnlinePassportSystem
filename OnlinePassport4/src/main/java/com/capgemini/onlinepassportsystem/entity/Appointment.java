package com.capgemini.onlinepassportsystem.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "a")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;
	private LocalDate date;
	private String scheduleAppointmentStatus;
	private long passportId;
	

	public Appointment()
	{
			
	}
	
	public Appointment(long  appointmentId, LocalDate date, String scheduleAppointmentStatus, long id) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.scheduleAppointmentStatus = scheduleAppointmentStatus;
		
	}
	
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getScheduleAppointmentStatus() {
		return scheduleAppointmentStatus;
	}
	public void setScheduleAppointmentStatus(String scheduleAppointmentStatus) {
		this.scheduleAppointmentStatus = scheduleAppointmentStatus;
	}
	public long getPassportId() {
		return passportId;
	}

	public void setPassportId(long l) {
		this.passportId = l;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", scheduleAppointmentStatus=" + scheduleAppointmentStatus + ",  Date=" + date +"]";
	}

	
	
}
