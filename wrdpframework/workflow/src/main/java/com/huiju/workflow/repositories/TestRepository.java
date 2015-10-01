package com.huiju.workflow.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huiju.workflow.entity.TestBusiness;

public interface TestRepository
        extends JpaRepository<TestBusiness, Serializable> {

}