package org.zhiyan.core.action;

import java.beans.Expression;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zhiyan.core.listener.AppLoaderListener;
import org.zhiyan.core.stereotype.Action;

/**
 * @Title: 公共控制类
 * @Description: 通用控制类
 * @Author:zhangzhiyan
 * @Since:2016年1月27日
 * @Version:1.1.0
 */
@Action
@RequestMapping("/common/")
public class CommonAction {

	@RequestMapping(value = "execute", method = RequestMethod.GET)
	public void execute(HttpServletRequest request) {
		System.out.println("hello");
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext(),
				AppLoaderListener.APP_CONTEXT_PREFIX + "RIA");
		Object bo = wac.getBean("userBO");
		Expression expression = new Expression(bo, "sayHello", new Object[] {});
		try {
			String a = (String) expression.getValue();
			System.out.println(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
