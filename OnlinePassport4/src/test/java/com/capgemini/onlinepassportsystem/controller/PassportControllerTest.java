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

import com.capgemini.onlinepassportsystem.entity.Passport;
import com.capgemini.onlinepassportsystem.services.PassportService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PassportController.class)
public class PassportControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PassportService passportService;

}