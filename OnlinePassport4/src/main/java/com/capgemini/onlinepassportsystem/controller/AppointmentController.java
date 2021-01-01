package com.capgemini.onlinepassportsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinepassportsystem.entity.Appointment;
import com.capgemini.onlinepassportsystem.entity.Passport;
import com.capgemini.onlinepassportsystem.exception.ResourceNotFoundException;
import com.capgemini.onlinepassportsystem.services.AppointmentService;



@RestController
@RequestMapping("/api/v1")
public class AppointmentController {
	
	private static final Logger logger = LogManager.getLogger(AppointmentController.class);
	
	@Autowired
	private AppointmentService appointmentRepository;

	@GetMapping("/getAllAppointment")
    public List<Appointment> getAllAppointment(){
		logger.info("In appointment Controller of getAllAppointment");
		logger.info("out appointment Controller of getAllAppointment");
	    
        return (List<Appointment>) appointmentRepository.getAllAppointment();
    }
	@PostMapping("/createAppointment")
    public Appointment createAppointment(@RequestBody Appointment appointment){
		logger.info("In appointment Controller of createAppointment ");
		logger.info("out appointment Controller of createAppointment ");
        return appointmentRepository.createAppointment(appointment);
    }
	@GetMapping("/getAppointmentById/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable Long appointmentId){
		logger.info("In appointment Controller of getAppointmentById ");
		logger.info("In appointment Controller of getAppointmentById ");
		return appointmentRepository.findAppointmentById(appointmentId);
    }

	@DeleteMapping("/deleteAppointmentById/{appointmentId}")
    public String deleteAppointmentById(@PathVariable Long appointmentId) throws ResourceNotFoundException{
		logger.info("In appointment Controller of deletePassportById ");
		logger.info("In appointment Controller of deletePassportById ");
		
		appointmentRepository.removeAppointment(appointmentId);
		
		return appointmentId+" Appointment Deleted Successfully"; 
	}
	
	@PutMapping("/updateAppointmentById/{ScheduleStatus:.+}/appointment/{appointmentId}")
	public Appointment updateAppointment(@PathVariable String ScheduleStatus,@PathVariable Long appointmentId)
	{
		logger.info("In appointment Controller of updatePassportById ");
		logger.info("In appointment Controller of updatePassportById ");
		
		return appointmentRepository.updateAppointmentById(appointmentId, ScheduleStatus);
		
	}
}
