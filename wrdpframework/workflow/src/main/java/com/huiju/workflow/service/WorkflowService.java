package com.huiju.workflow.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @Title: 工作流服务类
 * @Description: 提供工作流操作的一系列服务
 * @Author:zzy
 * @Since:2015年9月21日
 * @Version:1.1.0
 */
@Configuration
@Service
public class WorkflowService implements IWorkflowService {

	private static final long serialVersionUID = -2697730094379058749L;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private ManagementService managementService;

	@Autowired
	private IdentityService IdentityService;

	/**
	 * 开启工作流
	 * 
	 * @param processDefinitionKey
	 *            流程定义ID
	 * @return 流程实例ID
	 * @Description: 根据流程文件bpmn中定义的ID开启一个工作流实例
	 */
	@Override
	public String startProcessInstanceByKey(String processDefinitionKey) {
		return runtimeService.startProcessInstanceByKey(processDefinitionKey).getId();
	}

	/**
	 * 开启工作流
	 * 
	 * @param processDefinitionKey
	 *            流程定义ID
	 * @param variables
	 *            流程存储参数
	 * @return 流程实例ID
	 * @Description: 根据流程文件bpmn中定义的ID开启一个工作流实例，并传入相应的流程参数
	 */
	@Override
	public String startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) {
		return runtimeService.startProcessInstanceByKey(processDefinitionKey, variables).getId();
	}

	/**
	 * 开启工作流
	 * 
	 * @param processDefinitionKey
	 *            流程定义ID
	 * @param businessKey
	 *            业务主键
	 * @return 流程实例ID
	 * @Description: 根据流程文件bpmn中定义的ID开启一个工作流实例，并传入业务主键，以便跟业务联合查询使用
	 */
	@Override
	public String startProcessInstanceByKey(String processDefinitionKey, String businessKey) {

		return runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey).getId();
	}

	/**
	 * 开启工作流
	 * 
	 * @param processDefinitionKey
	 *            流程定义ID
	 * @param businessKey
	 *            业务主键
	 * @param variables
	 *            流程存储参数
	 * @return 流程实例ID
	 * @Description: 根据流程文件bpmn中定义的ID开启一个工作流实例，并传入业务主键和流程参数
	 */
	@Override
	public String startProcessInstanceByKey(String processDefinitionKey, String businessKey,
			Map<String, Object> variables) {
		return runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables).getId();
	}

	/**
	 * 获取用户任务
	 * 
	 * @param userAccount
	 *            用户账号
	 * @return 任务列表
	 * @Description: 根据用户账号获取用户所有任务列表
	 */
	public List<Task> findPersonalTasks(String userAccount) {
		return taskService.createTaskQuery().taskCandidateOrAssigned(userAccount).list();
	}

	@Override
	public void claimTask(String taskId, String userAccount) {
		taskService.claim(taskId, userAccount);
	}

	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

	@Override
	public void completeTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}

	@Override
	public void reassignTask() {
		// TODO Auto-generated method stub

	}
}
