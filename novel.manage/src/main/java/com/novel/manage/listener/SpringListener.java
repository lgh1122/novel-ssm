package com.novel.manage.listener;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.novel.common.mapper.TbNetMapper;
import com.novel.common.pojo.TbNet;
import com.novel.manage.converter.ManageConvent;

@Component
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private   TbNetMapper  netMapper;
	@Autowired
	private   Mapper mapper;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
	  	System.out.println("初始化======================初始化");
	  	List<TbNet> nets = netMapper.selectList();
		for (TbNet tbNet : nets) {
			ManageConvent.netMap.put(tbNet.getId(), tbNet);
		}
  		ManageConvent.mapper = mapper;
        }
	}

}
