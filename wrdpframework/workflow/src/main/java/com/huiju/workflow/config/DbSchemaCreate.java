package com.huiju.workflow.config;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;

public class DbSchemaCreate {

    public static void main(String[] args) {
        ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResourceDefault()
                .setDatabaseSchemaUpdate(
                        ProcessEngineConfigurationImpl.DB_SCHEMA_UPDATE_DROP_CREATE)
                .buildProcessEngine();
    }

}
