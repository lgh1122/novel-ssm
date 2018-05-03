package com.novel.manage.scheduler;

import java.util.List;

import com.novel.common.pojo.TbQuartzConfig;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

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
            List<TbQuartzConfig> quartzConfigs = null;//databseDao.findAll(TbQuartzConfig.class,queryRule);
            for (TbQuartzConfig tbQuartzConfig : quartzConfigs){
                saveJob(tbQuartzConfig);
            }
            LOG.warn("定时任务初始化成功------------------"+quartzConfigs.size()+"------------------");
        }catch (Exception e){
            LOG.error("定时任务初始化失败："+e.getMessage(),e);
        }

    }


    /**
     * 保存任务，同时进行更新或启动
     * @param tbQuartzConfig
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws SchedulerException
     */
    public  void saveJob(TbQuartzConfig tbQuartzConfig) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, SchedulerException {
       if ("1".equals(tbQuartzConfig.getValidStatus())){
           TriggerKey triggerKey = TriggerKey.triggerKey(tbQuartzConfig.getJobCode(),TRIGGER_GROUP);
           CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
           if (trigger == null){
               MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
               methodInvokingJobDetailFactoryBean.setName(tbQuartzConfig.getJobCode());
               methodInvokingJobDetailFactoryBean.setTargetObject(Class.forName(tbQuartzConfig.getTargetObject()).newInstance());
               methodInvokingJobDetailFactoryBean.setTargetMethod(tbQuartzConfig.getTargetMethod());
               methodInvokingJobDetailFactoryBean.afterPropertiesSet();
               methodInvokingJobDetailFactoryBean.setConcurrent("1".equals(tbQuartzConfig.getConCurrent()) ? true : false);
               JobDetail jobDetail = methodInvokingJobDetailFactoryBean.getObject();
               jobDetail.getJobDataMap().put("scheduleJob",tbQuartzConfig);
               CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(tbQuartzConfig.getCronExpression());
               trigger = TriggerBuilder.newTrigger().withIdentity(tbQuartzConfig.getJobCode(),JOB_GROUP).withSchedule(scheduleBuilder).build();
               scheduler.scheduleJob(jobDetail,trigger);
           }else {
               CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(tbQuartzConfig.getCronExpression());
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
