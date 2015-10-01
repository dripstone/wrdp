package com.huiju.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huiju.workflow.config.AppConfig;
import com.huiju.workflow.controller.TestService;
import com.huiju.workflow.dto.TestDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AppConfigTest {
	@Autowired
	TestService testService;

	@Test
	public void test() {
		testService.save(new TestDTO());
	}
}