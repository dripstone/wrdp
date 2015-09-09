package com.huiju.workflow.config;

import javax.sql.DataSource;

import org.activiti.engine.HistoryService;
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

    public @Bean SpringProcessEngineConfiguration processEngineConfiguration() {
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
        return configuration;
    }

    public @Bean ProcessEngineFactoryBean processEngine(
            SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        ProcessEngineFactoryBean factory = new ProcessEngineFactoryBean();
        factory.setProcessEngineConfiguration(springProcessEngineConfiguration);
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
        return processEngine.getTaskService();
    }

    public @Bean HistoryService historyService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }

    public @Bean ManagementService managementService(
            ProcessEngine processEngine) {
        return processEngine.getManagementService();
    }
}
