package com.novel.rest.listener;

import com.novel.common.mapper.TbNetMapper;
import com.novel.common.pojo.TbNet;
import com.novel.rest.converter.ManageConvent;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private   TbNetMapper  netMapper;
	@Autowired
	private   Mapper mapper;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
	  		List<TbNet> nets = netMapper.selectList();
			for (TbNet tbNet : nets) {
				ManageConvent.netMap.put(tbNet.getId(), tbNet);
			}
			ManageConvent.mapper = mapper;
        }
	}

}
