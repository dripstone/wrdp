package com.huiju.workflow.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class UserService {
	public String getUser() {
		System.out.println("zhangsan");
		return "zhangsan";
	}
}
