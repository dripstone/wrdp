package com.huiju.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.huiju.workflow.config.ActivitiConfig;

public class UserControllerStandaloneSetupTest {
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		ActivitiConfig userController = new ActivitiConfig();
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testView() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
				.andExpect(MockMvcResultMatchers.view().name("user/view"))
				.andExpect(MockMvcResultMatchers.model().attributeExists("user")).andDo(MockMvcResultHandlers.print())
				.andReturn();

		Assert.assertNotNull(result.getModelAndView().getModel().get("user"));
	}
}