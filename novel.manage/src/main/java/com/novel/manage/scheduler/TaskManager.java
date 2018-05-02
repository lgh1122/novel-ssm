package com.novel.manage.scheduler;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

import java.util.List;

/**
 * Created by Admin on 2017/11/10.
 */
public class TaskManager implements InitializingBean{

    private static Logger LOG = Logger.getLogger(TaskManager.class);

    private static final String JOB_GROUP = "SPRING_JOB_GROUP";

    private static final String TRIGGER_GROUP = "SPRING_TRIGGER_GROUP";

    @Autowired
    private Scheduler scheduler;



    @Override
    public void afterPropertiesSet() throws Exception {
        try {
          /*  QueryRule queryRule = QueryRule.getInstance();
            queryRule.addEqual("validStatus","1");*/
            List<UtiQuartzConfig> quartzConfigs = null;//databseDao.findAll(UtiQuartzConfig.class,queryRule);
            for (UtiQuartzConfig utiQuartzConfig : quartzConfigs){
                saveJob(utiQuartzConfig);
            }
            LOG.warn("定时任务初始化成功------------------"+quartzConfigs.size()+"------------------");
        }catch (Exception e){
            LOG.error("定时任务初始化失败："+e.getMessage(),e);
        }

    }


    /**
     * 保存任务，同时进行更新或启动
     * @param utiQuartzConfig
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws SchedulerException
     */
    public  void saveJob(UtiQuartzConfig utiQuartzConfig) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, SchedulerException {
       if ("1".equals(utiQuartzConfig.getValidStatus())){
           TriggerKey triggerKey = TriggerKey.triggerKey(utiQuartzConfig.getJobCode(),TRIGGER_GROUP);
           CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
           if (trigger == null){
               MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
               methodInvokingJobDetailFactoryBean.setName(utiQuartzConfig.getJobCode());
               methodInvokingJobDetailFactoryBean.setTargetObject(Class.forName(utiQuartzConfig.getTargetObject()).newInstance());
               methodInvokingJobDetailFactoryBean.setTargetMethod(utiQuartzConfig.getTargetMethod());
               methodInvokingJobDetailFactoryBean.afterPropertiesSet();
               methodInvokingJobDetailFactoryBean.setConcurrent("1".equals(utiQuartzConfig.getConCurrent()) ? true : false);
               JobDetail jobDetail = methodInvokingJobDetailFactoryBean.getObject();
               jobDetail.getJobDataMap().put("scheduleJob",utiQuartzConfig);
               CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(utiQuartzConfig.getCronExpression());
               trigger = TriggerBuilder.newTrigger().withIdentity(utiQuartzConfig.getJobCode(),JOB_GROUP).withSchedule(scheduleBuilder).build();
               scheduler.scheduleJob(jobDetail,trigger);
           }else {
               CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(utiQuartzConfig.getCronExpression());
               trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
               scheduler.rescheduleJob(triggerKey,trigger);
           }

       }
    }

    /**
     * 暂停任务
     * @param jobName
     * @throws SchedulerException
     */
    public void pauseJob(String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName,JOB_GROUP);
        scheduler.pauseJob(jobKey);
    }


    /**
     * 恢复任务
     * @param jobName
     * @throws SchedulerException
     */
    public void resumeJob(String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName,JOB_GROUP);
        scheduler.resumeJob(jobKey);
    }


    /**
     * 删除任务
     * @param jobName
     * @throws SchedulerException
     */
    public void deleteJob(String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName,JOB_GROUP);
        scheduler.deleteJob(jobKey);
    }

}
