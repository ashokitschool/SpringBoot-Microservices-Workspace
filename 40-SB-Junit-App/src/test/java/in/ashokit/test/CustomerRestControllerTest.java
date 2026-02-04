package in.ashokit.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.model.Customer;
import in.ashokit.rest.CustomerRestController;
import in.ashokit.service.CustomerService;
import tools.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CustomerRestController.class)
public class CustomerRestControllerTest {

	@MockitoBean
	private CustomerService customerService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveCustomer() throws Exception {

		// defining mock obj method behaviour
		when(customerService.saveCutomer(any(Customer.class))).thenReturn(true);

		Customer c = new Customer();
		c.setId(101);
		c.setName("Ashok");
		c.setEmail("ashok.b@gmail.com");
		
		// convert customer obj data into json format
		ObjectMapper mapper = new ObjectMapper();
		String customerJson = mapper.writeValueAsString(c);
		
		// prepare post request with json data in request body
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customer")
																.contentType("application/json")
																.content(customerJson);
		
		// send request and verify response
		mockMvc.perform(requestBuilder)
				.andExpect(status().isCreated());
				
	}
}












