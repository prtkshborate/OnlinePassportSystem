package com.capgemini.onlinepassportsystem.dao;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinepassportsystem.entity.Appointment;


@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long>{

	@Query(value = "SELECT u FROM Appointment u ORDER BY id")
	List<Appointment> findOrderAll();

	@Query(value = "SELECT u FROM Appointment u where u.scheduleAppointmentStatus = scheduleAppointmentStatus")
	Appointment findByscheduleAppointmentStatus(String scheduleAppointmentStatus);

}

