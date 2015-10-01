package com.huiju.workflow.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;

/**
 * @Title: 工作流服务接口
 * @Description: 提供工作流服务全部接口方法
 * @Author:zzy
 * @Since:2015年9月21日
 * @Version:1.1.0
 */
public interface IWorkflowService extends Serializable {

	/**
	 * 开启工作流实例
	 * 
	 * @param processDefinitionKey
	 *            流程定义ID
	 * @return 流程实例ID
	 * @Description: 根据流程文件bpmn中定义的ID开启一个工作流实例
	 */
	public String startProcessInstanceByKey(String processDefinitionKey);

	/**
	 * 开启工作流实例
	 * 
	 * @param processDefinitionKey
	 *            流程定义ID
	 * @param variables
	 *            流程存储参数
	 * @return 流程实例ID
	 * @Description: 根据流程文件bpmn中定义的ID开启一个工作流实例，并传入相应的流程参数
	 */
	public String startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables);

	/**
	 * 开启工作流实例
	 * 
	 * @param processDefinitionKey
	 *            流程定义ID
	 * @param businessKey
	 *            业务主键
	 * @return 流程实例ID
	 * @Description: 根据流程文件bpmn中定义的ID开启一个工作流实例，并传入业务主键，以便跟业务联合查询使用
	 */
	public String startProcessInstanceByKey(String processDefinitionKey, String businessKey);

	/**
	 * 开启工作流实例
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
	public String startProcessInstanceByKey(String processDefinitionKey, String businessKey,
			Map<String, Object> variables);

	/**
	 * 任务拾取
	 * 
	 * @param taskId
	 *            任务ID
	 * @param userAccount
	 *            用户账号
	 * @Description: 任务拾取后其他人看不到该任务
	 */
	public void claimTask(String taskId, String userAccount);

	/**
	 * 任务完成
	 * 
	 * @param taskId
	 *            任务ID
	 * @Description:
	 */
	public void completeTask(String taskId);

	/**
	 * 任务完成
	 * 
	 * @param taskId
	 *            任务ID
	 * @param variables
	 *            流程存储参数
	 * @Description:
	 */
	public void completeTask(String taskId, Map<String, Object> variables);

	public void reassignTask();

	public List<Task> findPersonalTasks(String userAccount);
}
