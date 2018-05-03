package com.novel.manage.controller;

 
import com.novel.common.pojo.TbQuartzConfig;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novel.manage.scheduler.TaskManager;

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
        TbQuartzConfig tbQuartzConfig = new TbQuartzConfig();
        tbQuartzConfig.setId((long) 2);
        tbQuartzConfig.setJobCode("autoTest");
        tbQuartzConfig.setConCurrent("1");
        tbQuartzConfig.setCronExpression("0/5 * * * * ?");
        tbQuartzConfig.setTargetObject("com.novel.manage.scheduler.TestJob");
        tbQuartzConfig.setTargetMethod("autoTest");
        tbQuartzConfig.setValidStatus("1");
        jobManager.saveJob(tbQuartzConfig);
        return "success";
    }
}
