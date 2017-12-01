package edu.cornell.haulers.contollers;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cornell.haulers.constants.HttpMappings;
import edu.cornell.haulers.entity.CustomerEntity;
import edu.cornell.haulers.util.TestDataGenerator;

import org.junit.runners.MethodSorters;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author mohitchawla
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext webappContext;

	@Autowired
	private ObjectMapper objectMapper;

	TestDataGenerator generator = new TestDataGenerator();

	/**
	 * Set up security context for Mocking user
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(webappContext).apply(springSecurity()).build();
	}

	@Test
	@WithMockUser(roles = "USER")
	public void test1AddCustomerSuccess() throws Exception {
		CustomerEntity validCustomer = generator.getValidCustomer();
		RequestBuilder requestBuilder = post(HttpMappings.CUSTOMER).with(csrf())
				.content(objectMapper.writeValueAsString(validCustomer))
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		mvc.perform(requestBuilder).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles = "USER")
	public void test2GetCustomerSuccess() throws Exception {
		RequestBuilder requestBuilder = get(HttpMappings.CUSTOMER)
				.param("email", generator.getValidCustomer().getEmail())
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		mvc.perform(requestBuilder).andExpect(status().isOk());
	}

}