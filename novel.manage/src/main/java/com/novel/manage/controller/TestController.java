package com.novel.manage.controller;

import com.novel.manage.scheduler.TaskManager;
import com.novel.manage.scheduler.UtiQuartzConfig;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Admin on 2017/11/12.
 */
@Controller("taskController")
@RequestMapping("/rest")
public class TestController {

    @Autowired
    private TaskManager jobManager;

    @RequestMapping("/add")
    @ResponseBody
    public String testAddTask() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, SchedulerException, IllegalAccessException {
        UtiQuartzConfig utiQuartzConfig = new UtiQuartzConfig();
        utiQuartzConfig.setId(2);
        utiQuartzConfig.setJobCode("autoTest");
        utiQuartzConfig.setConCurrent("1");
        utiQuartzConfig.setCronExpression("0/5 * * * * ?");
        utiQuartzConfig.setTargetObject("com.novel.manage.scheduler.TestJob");
        utiQuartzConfig.setTargetMethod("autoTest");
        utiQuartzConfig.setValidStatus("1");
        jobManager.saveJob(utiQuartzConfig);
        return "success";
    }
}
