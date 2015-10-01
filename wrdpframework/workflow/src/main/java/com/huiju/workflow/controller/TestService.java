package com.huiju.workflow.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huiju.workflow.dto.TestDTO;
import com.huiju.workflow.entity.TestBusiness;
import com.huiju.workflow.repositories.TestRepository;
import com.huiju.workflow.service.IWorkflowService;

@Service
public class TestService {

    @Autowired
    IWorkflowService workflowService;
    @Autowired
    private TestRepository testRepository;

    /**
     * Spring的AOP即声明式事务管理默认是针对unchecked exception回滚。
     * 也就是默认对RuntimeException()异常或是其子类进行事务回滚； checked异常,即Exception可try{}捕获的不会回滚，
     * 如果使用try-catch捕获抛出的unchecked异常后没有在catch块中 采用页面硬编码的方式使用spring
     * api对事务做显式的回滚，则事务不会回滚， “将异常捕获,并且在catch块中不对事务做显式提交=生吞掉异常” ，
     * 要想捕获非运行时异常则需要如下配置： rollbackForClassName = "java.lang.Exception"
     * 
     * @param testDTO
     * @Description:
     */
    public void save(TestDTO testDTO) {
        TestBusiness entity = new TestBusiness();
        entity.setId(testDTO.getBusinessID());
        entity.setName(testDTO.getBusinessName());
        entity = testRepository.save(entity);
        // String instID =
        // workflowService.startProcessInstanceByKey(testDTO.getWfDefinitionID(),
        // entity.getId());

        // System.out.println(instID);
    }

    public List<TestDTO> getAll(String userAccount) {
        // testRepository.findAll();
        List<Task> list = workflowService.findPersonalTasks(userAccount);
        return null;
    }
}
