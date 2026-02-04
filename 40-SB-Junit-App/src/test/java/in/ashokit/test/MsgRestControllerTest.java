package in.ashokit.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.rest.MsgRestController;
import in.ashokit.service.MsgService;

@WebMvcTest(controllers = MsgRestController.class)
public class MsgRestControllerTest {

	@MockitoBean
	private MsgService msgService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testWelcomeMsg() throws Exception {

		// defining mock obj behaviour to return some value
		when(msgService.getWelcomeMsg()).thenReturn("Dummy Text");
		
		// defining mock obj behaviour for void methods
		doNothing().when(msgService).sendEmail();
		
		// preparing HTTP Request
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");

		// Sending HTTP Request
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		// Capturing HTTP Response given by REST API
		MockHttpServletResponse response = result.getResponse();

		String contentAsString = response.getContentAsString();

		int status = response.getStatus();

		// Validating Response using Assertions
		Assertions.assertEquals(200, status);

	}

}
