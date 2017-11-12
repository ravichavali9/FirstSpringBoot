package com.learning.personmanagement;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.nio.charset.Charset;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runners.MethodSorters;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonManagementApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	    
	String endPoint="/person";
	    
	@Test
	public void test0_GetAllPersons() throws Exception{
		mockMvc.perform(get(endPoint+"/list")
	             .contentType(contentType))
	             .andExpect(status().isOk())
	             .andExpect(jsonPath("$", hasSize(3)))
	             .andExpect(jsonPath("$[0].id", is(1)))
	             .andExpect(jsonPath("$[0].name", is(5)))
	             .andExpect(jsonPath("$[0].address", is("GAS")))
	             .andExpect(jsonPath("$[0].DOB", is("")));
	     }
	}
