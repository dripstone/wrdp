package org.zhiyan.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class UserControllerStandaloneSetupTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        // UserController userController = new UserController();
        // mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testView() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(MockMvcResultMatchers.view().name("user/view"))
                .andExpect(
                        MockMvcResultMatchers.model().attributeExists("user"))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        Assert.assertNotNull(result.getModelAndView().getModel().get("user"));
    }
}