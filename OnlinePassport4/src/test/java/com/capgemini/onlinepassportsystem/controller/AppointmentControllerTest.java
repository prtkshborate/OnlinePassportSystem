package com.capgemini.onlinepassportsystem.controller;


import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.capgemini.onlinepassportsystem.entity.Appointment;
import com.capgemini.onlinepassportsystem.services.AppointmentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AppointmentController.class)
public class AppointmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AppointmentService appointmentService;

	@Test
	public void testDeleteAppointmentById() throws Exception {
		String URI = "/api/v1/deleteAppointmentById/{appointmentId}";

		Appointment appointment = new Appointment();
		appointment.setAppointmentId(101);
		appointment.setDate(LocalDate.now());
		appointment.setPassportId(1);
		appointment.setScheduleAppointmentStatus("Schedule");

		Mockito.when(appointmentService.findAppointmentById(Mockito.any())).thenReturn(appointment);
		Mockito.when(appointmentService.removeAppointment(Mockito.any())).thenReturn(appointment);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}

	/*
	 * @Test public void updateAppointmentById() throws Exception { String URI =
	 * "/updateAppointmentById/{ScheduleStatus:.+}/appointment/{appointmentId}";
	 * Appointment appointment = new Appointment();
	 * appointment.setAppointmentId(101); appointment.setDate(LocalDate.now());
	 * appointment.setPassportId(1);
	 * appointment.setScheduleAppointmentStatus("Schedule");
	 * 
	 * try { String jsonInput = this.converttoJson(appointment);
	 * 
	 * Mockito.when(appointmentService.updateAppointmentById(Mockito.any(),
	 * Mockito.anyString())).thenReturn(appointment); MvcResult mvcResult =
	 * this.mockMvc.perform(MockMvcRequestBuilders.put(URI, "NotSchedule", 101)
	 * .accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.
	 * APPLICATION_JSON)) .andReturn(); MockHttpServletResponse
	 * mockHttpServletResponse = mvcResult.getResponse(); String jsonOutput =
	 * mockHttpServletResponse.getContentAsString();
	 * 
	 * assertThat(jsonInput).isEqualTo(jsonOutput); } catch(Exception e) {} }
	 * 
	 * private String converttoJson(Object appointment) throws
	 * JsonProcessingException { ObjectMapper objectMapper = new ObjectMapper();
	 * return objectMapper.writeValueAsString(appointment); }
	 */
}
