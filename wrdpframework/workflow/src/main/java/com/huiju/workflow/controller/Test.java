package com.huiju.workflow.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/")
public class Test {
	@Autowired
	ProcessEngine processEngine;

	@RequestMapping
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws BeansException, Exception {
		// 获取 RepositoryService
		// RepositoryService repositoryService =
		// processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 使用 RepositoryService 部署流程定义
		// repositoryService.createDeployment().addClasspathResource("bpmn/MyProcess.bpmn").deploy();
		// 使用 RuntimeService 创建一个流程的实例
		String procId = runtimeService.startProcessInstanceByKey("myProcess").getId();

		// runtimeService.startProcessInstanceByKey("myProcess", "aaa");

		// 获取 TaskService 获取任务服务
		TaskService taskService = processEngine.getTaskService();
		// 使用 TaskService 获取指定用户组的 Task 列表并使用指定用户领取这些任务
		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("lisi").list();
		for (Task task : tasks) {
			System.out.println("Following task is available for accountancy group: " + task.getName());
			// 任务拾取，拾取任务后，其他人看不到该任务
			taskService.claim(task.getId(), "zhangsan");
			// taskService.complete(taskId, variables);
		}

		System.out
				.println("Number of tasks for fozzie: " + taskService.createTaskQuery().taskAssignee("fozzie").count());

		// 使用 HistoryService 来查询指定流程实例的状态
		HistoryService historyService = processEngine.getHistoryService();
		HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceId(procId).singleResult();
		System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());
	}
}
