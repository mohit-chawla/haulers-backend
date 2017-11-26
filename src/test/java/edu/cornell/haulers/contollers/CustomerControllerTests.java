package edu.cornell.haulers.contollers;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cornell.haulers.constants.HttpMappings;
import edu.cornell.haulers.entity.CustomerEntity;
import edu.cornell.haulers.util.TestDataGenerator;

import org.junit.runners.MethodSorters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	TestDataGenerator generator = new TestDataGenerator();

	@Test
	public void test1AddCustomerSuccess() throws Exception {
		CustomerEntity validCustomer = generator.getValidCustomer();
		RequestBuilder requestBuilder = post(HttpMappings.CUSTOMER).content(objectMapper.writeValueAsString(validCustomer)).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		mvc.perform(requestBuilder).andExpect(status().isOk());
	}
	
	
	@Test
	public void test2GetCustomerSuccess() throws Exception {
		RequestBuilder requestBuilder = get(HttpMappings.CUSTOMER).param("email", generator.getValidCustomer().getEmail()).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		mvc.perform(requestBuilder).andExpect(status().isOk());
	}

}