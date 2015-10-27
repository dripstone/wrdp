package com.huiju.workflow.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class ActivitiConfig {
    @Autowired
    private Environment env;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PlatformTransactionManager transactionManager;

    // private String databaseSchemaUpdate = "DRIPSTONE";
    private boolean jobExecutorActivate = false;

    public @Bean SpringProcessEngineConfiguration processEngineConfiguration()
            throws IOException {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setTransactionManager(transactionManager);
        // 数据库名oracle是用户名，注：参数必须大写
        // configuration.setDatabaseSchema(databaseSchemaUpdate);
        configuration.setJobExecutorActivate(jobExecutorActivate);
        String dbCreate = env.getProperty("activiti.db_create");
        if ("true".equals(dbCreate)) {
            configuration.setDatabaseSchemaUpdate(
                    env.getProperty("activiti.database_schema_Update"));
            configuration.buildProcessEngine();
        }
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] bpmnResources = resourcePatternResolver
                .getResources("classpath*:**/*.bpmn");
        configuration.setDeploymentResources(bpmnResources);
        // List<SessionFactory> sessionFactoryList = new
        // ArrayList<SessionFactory>();
        // sessionFactoryList.add(new SmartGapGroupEntityManagerFactory());
        // sessionFactoryList.add(new SmartGapUserEntityManagerFactory());
        // configuration.setCustomSessionFactories(sessionFactoryList);
        // 集成到开发平台中时，需要设置false，不创建用户表，创建视图来代替这些用户，视图数据来源为平台中的用户数据
        // configuration.setDbIdentityUsed(false);

        return configuration;
    }

    public @Bean ProcessEngineFactoryBean processEngine(
            SpringProcessEngineConfiguration processEngineConfiguration) {
        ProcessEngineFactoryBean factory = new ProcessEngineFactoryBean();
        factory.setProcessEngineConfiguration(processEngineConfiguration);
        return factory;
    }

    public @Bean RepositoryService repositoryService(
            ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }

    public @Bean RuntimeService runtimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }

    public @Bean TaskService taskService(ProcessEngine processEngine) {
        TaskService taskService = processEngine.getTaskService();
        return taskService;
    }

    public @Bean HistoryService historyService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }

    public @Bean ManagementService managementService(
            ProcessEngine processEngine) {
        return processEngine.getManagementService();
    }

    public @Bean IdentityService IdentityService(ProcessEngine processEngine) {
        return processEngine.getIdentityService();
    }
}
