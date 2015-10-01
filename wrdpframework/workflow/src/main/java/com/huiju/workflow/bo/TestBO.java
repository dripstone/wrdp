package com.huiju.workflow.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.huiju.workflow.controller.TestService;
import com.huiju.workflow.dto.TestDTO;

@Controller
@Order(100)
@RequestMapping(value = "/test")
public class TestBO {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    public ModelAndView createUser(TestDTO testDTO) throws Exception {
        testService.save(testDTO);
        // testService.getAll("zhangsan");
        List<TestDTO> list = new ArrayList<TestDTO>();
        list.add(testDTO);
        if (true)
            throw new RuntimeException("sss");
        return new ModelAndView("index", "rf", list);
    }
}
